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
        from("timer:hello?period={{timer.period}}").routeId("hello")
            .transform().method("myBean", "saySomething")
            .filter(simple("${body} contains 'foo'"))
                .to("log:foo")
            .end()
            .to("stream:out");

            from("timer:mytimer?repeatCount=1")
            .setHeader("Authorization", method(GhostApiTokenGeneratorBean.class, "getToken"))
            .log("${header.Authorization}")
            .to("stream:out");
            //.to("direct:nextRoute"); 



        //Open511 API GET 10 Events - only once
        // from("timer:mytimer?repeatCount=1")
        //     .toD("http://${properties:open511.events}" +  "?httpMethod=GET" + "&${properties:open511.limit}")
        //     .unmarshal(new JacksonDataFormat(Open511Events.class))
        //     .marshal().jacksonxml(true)
        //     .to("stream:out")
        //     .log("Response code from the Open 511 call was: ${header.CamelHttpResponseCode}");
    
         // Get Ghost CMS Authoriztaion Time - required for PUT
        //  from("timer:mytimer?repeatCount=1")
        //  .toD("http://${properties:ghostcms.destination}${properties:ghostcms.postid}" +  "?httpMethod=GET" )
        //  .log("Response body from the GhostCMS call operation was: ${body}")
        //  ;
    

    }

}
