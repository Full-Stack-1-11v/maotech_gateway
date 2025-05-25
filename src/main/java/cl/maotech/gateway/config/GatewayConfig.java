package cl.maotech.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // Auth Service Routes
                .route("auth-login", r -> r.path("/api/auth/login")
                        .uri("http://localhost:8081"))
                .route("auth-register", r -> r.path("/api/auth/register")
                        .uri("http://localhost:8081"))
                .route("auth-validate", r -> r.path("/api/auth/validate")
                        .uri("http://localhost:8081"))

                // User Service Routes
                .route("users", r -> r.path("/api/users/**")
                        .uri("http://localhost:8082"))

                // Content Service Routes
                .route("content", r -> r.path("/api/content/**")
                        .uri("http://localhost:8083"))

                // Course Service Routes
                .route("courses", r -> r.path("/api/courses/**")
                        .uri("http://localhost:8084"))

                .build();
    }
}