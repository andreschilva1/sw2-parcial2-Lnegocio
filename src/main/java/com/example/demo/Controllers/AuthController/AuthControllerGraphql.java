package com.example.demo.Controllers.AuthController;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Request.LoginRequest;
import com.example.demo.Request.RegisterRequest;

import graphql.kickstart.tools.GraphQLMutationResolver;


@RestController
@RequiredArgsConstructor
public class AuthControllerGraphql implements GraphQLMutationResolver{


    @Autowired
    private final AuthService authService;


    @MutationMapping
    public AuthResponse login(@Argument LoginRequest request) {
        return authService.login(request);
    }

    @MutationMapping
    public AuthResponse register(@Argument RegisterRequest request) {

        return authService.register(request);
    }

    

}