package org.pharmacy.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/*Sabyasachi*/
@EnableEurekaServer
@SpringBootApplication
public class OrganizationServer {

    public static void main(String[] args) {
        SpringApplication.run(OrganizationServer.class, args);
    }

}
