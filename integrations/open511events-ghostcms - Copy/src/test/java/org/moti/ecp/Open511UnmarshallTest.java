package org.moti.ecp;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

public class Open511UnmarshallTest extends CamelTestSupport {

    @Test
    public void givenOpen511EventsList_whenUnmarshalled_thenSuccess() throws Exception {
        MockEndpoint mock = getMockEndpoint("mock:marshalledObject");
        mock.expectedMessageCount(1);
        mock.message(0).body().isInstanceOf(Open511Events.class);

        String json = readJsonFromFile("/open511events.json");
        template.sendBody("direct:jsonInput", json);
        assertMockEndpointsSatisfied();

        // Open511Events open511Events = mock.getReceivedExchanges().get(0).getIn().getBody(Open511Events.class);
        // assertNotNull("Open 511 Events list should not be null", open511Events);

        // List<Open511Events> events = open511Events.getEvents();
        // assertEquals("There should be two events", 2, events.size());

        // Open511Events open511event = events.get(0);
        // assertEquals("Fruit name", "Banana", fruit.getName());
        // assertEquals("Fruit id", 100, fruit.getId());

        // fruit = fruits.get(1);
        // assertEquals("Fruit name", "Apple", fruit.getName());
        // assertEquals("Fruit id", 101, fruit.getId());
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:jsonInput").unmarshal(new JacksonDataFormat(Open511Events.class))
                    .to("mock:marshalledObject");
            }
        };
    }

    private String readJsonFromFile(String path) throws URISyntaxException, IOException {
        URL resource = Open511UnmarshallTest.class.getResource(path);
        return new String(Files.readAllBytes(Paths.get(resource.toURI())));
    }


}
