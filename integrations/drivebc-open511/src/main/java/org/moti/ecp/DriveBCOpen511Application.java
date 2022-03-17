package org.moti.ecp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.camel.zipkin.starter.CamelZipkin;

@SpringBootApplication
@CamelZipkin
public class DriveBCOpen511Application {

    /**
     * A main method to start this application.
     */
    public static void main(String[] args) {
        SpringApplication.run(DriveBCOpen511Application.class, args);
    }

}
