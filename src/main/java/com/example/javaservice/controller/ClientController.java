package com.example.javaservice.controller;

import com.example.javaservice.model.dto.ClientDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    @PostMapping
    public void createNewClient( ClientDto dto ) {
    }
    @PostMapping
    public void authenticationClient ( String email, String password){
    }

}
