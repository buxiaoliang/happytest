package test4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * - DB Project:
 * Consider that we are a service provider to provide customers different services.
 * Each customer can subscribe to multiple service and each service can be subscribed to by multiple customers.
 * Come up a database schema to model the service-customer relationship.
 * And use java/html/tomcat/db of your choice to implement a simple web app that will display a customer's subscriptions
 * and let the customer subscribe to a new service, modify or delete a subscribed service.
 * Design
 * 1) Use thymeleaf to show the web
 * 2) Create three tables
 * 3) Handle the relationships in VO
 */
@SpringBootApplication
public class CustomerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
}
