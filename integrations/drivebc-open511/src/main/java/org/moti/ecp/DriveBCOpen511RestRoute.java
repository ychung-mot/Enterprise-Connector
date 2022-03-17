package org.moti.ecp;

import javax.annotation.processing.Processor;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import io.swagger.models.parameters.QueryParameter;

import org.apache.camel.model.rest.RestBindingMode;


/**
 * Rest API to be consumed by DriveBC - Proxy to Open511
 */

@Component
public class DriveBCOpen511RestRoute extends RouteBuilder {

  @Override
  public void configure() {
    
    // This section is required - it tells Camel how to configure the REST service
    restConfiguration() 
    .component("netty-http")
    .port(8081)
    .enableCORS(true)

    .bindingMode(RestBindingMode.json);

    // rest("/integration")
    rest()
        .path("/api") // This makes the API available at http://host:port/$CONTEXT_ROOT/api
        .consumes("application/json")
        .produces("application/json")
        
        //.get("/events")
        .get("/events") 
          .route().routeId("rest-open511-events")     
          .to("direct:rest-open511-events")
        .endRest();

    // .get("/events/{parameters}")
    // .route().routeId("rest-open511-eventswithparameters")
    // .to("direct:rest-open511-eventswithparameters")
    // .endRest();

    // from("quartz://driveBCOpen511eventsTimer?cron=10+*+*+*+*+?") // CRON format
    // for every 10 minutes
    // .routeId("drivebcopen511events")
    // .toD("http://${properties:open511.events}" + "?httpMethod=GET" +
    // "&${properties:open511.parameters}")
    // .to("file:{{open511.jsonfilepath}}?fileName=${properties:open511.jsonfile}&charset=utf-8")
    // .end();
  }
 

}
