package org.moti.ecp;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.component.jackson.ListJacksonDataFormat;
import org.springframework.stereotype.Component;

/**
 * A simple Camel route that triggers from a timer and calls a bean and prints to system out.
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */
@Component
public class MySpringBootRouter extends RouteBuilder {

    @Override
    public void configure() {
        from("timer:hello?period={{timer.period}}").routeId("hello")
            .transform().method("myBean", "saySomething")
            .filter(simple("${body} contains 'foo'"))
                .to("log:foo")
            .end()
            .to("stream:out");

        //Open511 API GET 10 Events - only once
        from("timer:mytimer?repeatCount=1")
            .toD("http://${properties:open511.events}" +  "?httpMethod=GET" + "&${properties:open511.limit}")
            .unmarshal(new JacksonDataFormat(Open511Events.class))
            //.unmarshal(new ListJacksonDataFormat(Open511Events.class))
            //.to("mock:marshalledObject")
            .log("Response code from the Open 511 call was: ${header.CamelHttpResponseCode}");
            //.log("Response body from the Open 511 call operation was: ${body}");

    }

}
