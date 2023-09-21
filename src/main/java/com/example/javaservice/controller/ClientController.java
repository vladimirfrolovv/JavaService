package com.example.javaservice.controller;

import com.example.javaservice.model.dto.ClientDto;
import com.example.javaservice.model.entity.Client;
import com.example.javaservice.model.mapper.ClientMapper;
import com.example.javaservice.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
//    private final ClientMapper clientMapper;
    @PostMapping(value = "/clients")
    public void createNewClient ( @RequestBody ClientDto clientDto ) {
        clientService.createClient(ClientMapper.INSTANCE.toEntity(clientDto));

    }
    @GetMapping(value = "/{id}")
    public ClientDto getClientById( @PathVariable(name = "id") Long id ) {
        Client client = clientService.getClientById(id);
        return ClientMapper.INSTANCE.toDTO(client);
    }
//    @PostMapping
//    public void authenticationClient ( String email, String password ) {
//    }
}
