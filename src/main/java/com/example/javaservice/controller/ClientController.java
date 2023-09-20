package com.example.javaservice.controller;

import com.example.javaservice.model.dto.ClientDto;
import com.example.javaservice.model.mapper.ClientMapper;
import com.example.javaservice.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping(value = "/clients")
    public void createNewClient ( @RequestBody ClientDto clientDto ) {
        clientService.createClient(ClientMapper.INSTANCE.toEntity(clientDto));
    }

//    @PostMapping
//    public void authenticationClient ( String email, String password ) {
//    }
}
