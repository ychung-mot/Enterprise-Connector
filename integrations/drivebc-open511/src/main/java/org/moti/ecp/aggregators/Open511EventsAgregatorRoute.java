package org.moti.ecp.aggregators;

import javax.servlet.http.HttpServletRequest;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.http.base.HttpOperationFailedException;
import org.springframework.stereotype.Component;

@Component
public class Open511EventsAgregatorRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:rest-open511-events")
        .process(new Processor() {
            public void process(Exchange exchange) throws Exception {
                // get query string from DriveBC
                String queryString = exchange.getIn().getHeader(Exchange.HTTP_QUERY, String.class);
                // Get request from DriveBC               
               
                // Set query string for Open511 from DriveBC reqeust
               exchange.getIn().setHeader(Exchange.HTTP_QUERY, queryString);
           }})
                .routeId("open511-events-service")

                //.removeHeaders("CamelHttp*")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                // bridgeEndpoint=true enables the camel querystring to be passed through
                .toD("http://{{open511.events}}" + "?httpMethod=GET&bridgeEndpoint=true" ) 
                .unmarshal(new JacksonDataFormat())
                ;

    }
    
    
}
