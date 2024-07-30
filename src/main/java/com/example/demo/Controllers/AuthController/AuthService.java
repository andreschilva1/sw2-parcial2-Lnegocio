
package com.example.demo.Controllers.AuthController;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.Request.LoginRequest;
import com.example.demo.Request.RegisterRequest;
import com.example.demo.models.User;
import com.example.demo.models.User.Role;
import com.example.demo.utils.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

        private final UserRepository userRepository;

        private final JwtService jwtService;
        private final PasswordEncoder passwordEncoder;
        private final AuthenticationManager authenticationManager;

        public AuthResponse login(LoginRequest request) {
                authenticationManager
                                .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),
                                                request.getPassword()));
                UserDetails user = userRepository.findByUsername(request.getEmail()).orElseThrow();
                String token = jwtService.getToken(user);
                return AuthResponse.builder()
                                .token(token)
                                .build();
        }

        public AuthResponse register(RegisterRequest request) {
                User user = User.builder()
                                .username(request.getEmail())
                                .password(passwordEncoder.encode(request.getPassword()))
                                .email(request.getEmail())
                                .role(Role.ADMIN)
                                .build();

               /*  LocalDate localDate = LocalDate.parse(request.getBirth_date(),
                                DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                Date date = java.sql.Date.valueOf(localDate); */

                userRepository.save(user);
                return AuthResponse.builder()
                                .token(jwtService.getToken(user))
                                .build();
        }

}
