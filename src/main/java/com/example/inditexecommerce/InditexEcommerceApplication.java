package com.example.inditexecommerce;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InditexEcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InditexEcommerceApplication.class, args);
    }

    @Bean
    public OpenAPI inditexOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Inditex Spring Boot 3 API")
                        .version("1.0.0")
                        .description("E-commerce Inditex demo application")
                        .termsOfService("http://swagger.io/terms")
                        .contact(new Contact().name("Bruno Kiryluk").email("brunokiryluk@gmail.com"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
