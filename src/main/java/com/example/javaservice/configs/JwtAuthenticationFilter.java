//package com.example.javaservice.configs;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.AllArgsConstructor;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@AllArgsConstructor
//public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//    private final AuthenticationManager authenticationManager;
//
//    @Override
//    public Authentication attemptAuthentication( HttpServletRequest request, HttpServletResponse response) {
//        String username = obtainUsername(request);
//        String password = obtainPassword(request);
//        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//    }
//
//
//}
