package com.example.backend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Step 3: CORS configuration.
 * Only active when  app.cors.enabled=true  in application.properties.
 */
@Configuration
@ConditionalOnProperty(name = "app.cors.enabled", havingValue = "true")
public class CorsConfig implements WebMvcConfigurer {

    @Value("${app.cors.allowed-origin}")
    private String allowedOrigin;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/profile/**")
                .allowedOrigins(allowedOrigin)               // specific origin only (no "*")
                .allowedMethods("GET", "PUT", "OPTIONS")      // DELETE/POST deliberately excluded
                .allowedHeaders("Content-Type")
                .maxAge(3600);
    }
}
