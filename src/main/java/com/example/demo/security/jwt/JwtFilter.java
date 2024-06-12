package com.example.demo.security.jwt;

import org.apache.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import io.jsonwebtoken.lang.Strings;
import reactor.core.publisher.Mono;

@Component
public class JwtFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getPath().value();
        if (!path.equals("/auth/login")) {
            String auth = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
            if (!Strings.hasText(auth) || !auth.startsWith("Bearer ")) {
                return Mono.error(new Exception("JWT incorrecto"));
                
            }
            String token = auth.replace("Bearer ", "");
            exchange.getAttributes().put("token", token);
        }
        return chain.filter(exchange);
    }
}
