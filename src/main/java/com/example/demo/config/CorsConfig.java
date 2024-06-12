package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")  // Permite CORS en todos los endpoints
                        .allowedOrigins("*")  // Permite peticiones desde cualquier origen
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Métodos HTTP permitidos
                        .allowedHeaders("*")  // Permite todas las cabeceras
                        .allowCredentials(false)  // Permite credenciales
                        .maxAge(3600);  // Tiempo máximo que el resultado de una pre-solicitud puede ser almacenado en caché por el cliente
            }
        };
    }
}
