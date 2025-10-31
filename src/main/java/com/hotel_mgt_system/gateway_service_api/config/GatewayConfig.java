package com.hotel_mgt_system.gateway_service_api.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("hotel-management-system", r -> r.path("/hotel-management/**")
                        .uri("http://localhost:8081"))

                .route("auth-service-api", r -> r.path("/user-service/**")
//                        .filters(f -> f.stripPrefix(1))
                        .uri("http://localhost:8083"))
                .build();
    }
}
