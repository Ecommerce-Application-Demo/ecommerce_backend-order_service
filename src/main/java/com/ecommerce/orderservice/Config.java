package com.ecommerce.orderservice;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Configuration
public class Config {

    @Autowired
    Environment env;

    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Order Service")
                        .description("JAVA Backend API Documentation for Ecommerce Order Service")
                        .version("v0.1")
                        .license(new License().name("MIT License").url("https://opensource.org/license/mit")))
                .externalDocs(new ExternalDocumentation()
                        .description("Github")
                        .url("https://github.com/Ecommerce-Application-Demo/ecommerce-backend"));
    }

    @Scheduled(fixedDelay = 1000*60*5)
    void renderRunner() {
        if (Arrays.asList(env.getActiveProfiles()).contains("prod")) {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getForEntity("https://ecommerce-backend-order-service.onrender.com/order/actuator/info", String.class);
        }
    }
}
