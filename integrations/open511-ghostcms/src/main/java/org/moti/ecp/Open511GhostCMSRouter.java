package org.moti.ecp;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.moti.ecp.beans.GhostApiTokenGeneratorBean;
import org.moti.ecp.types.Open511Events;
import org.springframework.stereotype.Component;

/**
   Camel route to load most recent Open 511 Road events to Drive BC Ghost CMS site.
 */
@Component
public class Open511GhostCMSRouter extends RouteBuilder {

    @Override
    public void configure() {
        
        //Open511 API GET 10 Events - only once
        from("timer:open511events?fixedRate=true&period=60000")
            .toD("http://${properties:open511.events}" +  "?httpMethod=GET" + "&${properties:open511.limit}")
            .unmarshal(new JacksonDataFormat(Open511Events.class))
            .marshal().jacksonxml(true)
            // .to("stream:out")
            // .log("Response code from the Open 511 call was: ${header.CamelHttpResponseCode}");

            // Generate token and set header for Ghost CMS authorization
          //  from("timer:mytimer?repeatCount=1")
            .setHeader("Authorization", method(GhostApiTokenGeneratorBean.class, "getToken"))
            //.log("${header.Authorization}")
            .log("Ghost CMS Token Generated")
//            .to("log:out")
            // Get post details and capture date of last change as this will be required for publishing an update.
            .toD("http://${properties:ghostcms.ghostcmshostname}${properties:ghostcms.postid}" +  "?httpMethod=GET" )
            .log("Ghost CMS Page Call")
            .end(); 




    
         // Get Ghost CMS Posts 
        //  from("timer:mytimer?repeatCount=1")
        //  .toD("http://${properties:ghostcms.destination}${properties:ghostcms.postid}" +  "?httpMethod=GET" )
        //  .log("Response body from the GhostCMS call operation was: ${body}")
        //  ;
    

    }

}
