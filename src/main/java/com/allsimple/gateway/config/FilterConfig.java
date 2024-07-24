package com.allsimple.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

        @Bean
        public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
                return builder.routes()
                                .route(r -> r.path("/api/v1/**")
                                                .filters(f -> f.addRequestHeader("first-request",
                                                                "first-request-header")
                                                                .addResponseHeader("first-response",
                                                                                "first-response-header"))
                                                .uri("http://192.168.77.11:8083"))
                                .route(r -> r.path("/api/v2/**")
                                                .filters(f -> f.addRequestHeader("second-request",
                                                                "second-request-header")
                                                                .addResponseHeader("second-response",
                                                                                "second-response-header"))
                                                .uri("http://192.168.77.11:8083"))
                                .build();
        }
}
