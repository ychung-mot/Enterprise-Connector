package org.moti.ecp.beans;

// Bean for creating json web token.  See Java JWT: JSON Web Token for Java and Android
// https://github.com/jwtk/jjwt#jws-create
//

import org.apache.camel.spi.annotations.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import io.jsonwebtoken.*;
import io.jsonwebtoken.Jwts;

@Component("generateGhostAPITokenBean")
public class GhostApiTokenGeneratorBean {

	@Value("${ghostcms.daysToLive}")
	private Integer daysToLive;
	@Value("${ghostcms.SECRET_KEY}")
	private String SECRET_KEY;
	@Value("${ghostcms.jwtId}")
	private String jwtId;
	@Value("${ghostcms.jwtAudience}")
	String jwtAudience;

	public String getToken() {
		String jwt = GhostApiTokenGeneratorBean.createJWT(
				jwtId, // claim = jti
				jwtAudience, // claim = audience
				daysToLive,
				SECRET_KEY // used to calculate expiration (claim = exp)
		);
		return ("Ghost " + jwt.toString());
	}

	// Method to construct a JWT
	public static String createJWT(String keyid, String audience, int daysToLive, String SECRET_KEY) {

		// The JWT signature algorithm we will be using to sign the token
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		Date expiryDate = new Date(nowMillis);
		ZoneId defaultZoneId = ZoneId.systemDefault();
		LocalDate localDate = LocalDate.now().plusDays(daysToLive);
		expiryDate = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		// Sign JWT with ApiKey secret
		byte[] apiKeySecretBytes = DatatypeConverter.parseHexBinary(SECRET_KEY);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		// Build token
		JwtBuilder builder = Jwts.builder()
				.signWith(signingKey, signatureAlgorithm)
				.setExpiration(expiryDate)
				.setAudience(audience)
				.setIssuedAt(new Date())
				.setHeaderParam("kid", keyid) // kid - Unique identifier for the certificate
		;

		// Builds the JWT and serializes it to a compact, URL-safe string
		return builder.compact();
	}

}
