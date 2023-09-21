package com.example.javaservice.controller;

import com.example.javaservice.model.dto.ClientDto;
import com.example.javaservice.model.entity.Client;
import com.example.javaservice.model.mapper.ClientMapper;
import com.example.javaservice.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    @PostMapping(value = "/clients")
    public void createNewClient ( @RequestBody ClientDto clientDto ) {
        clientService.createClient(ClientMapper.INSTANCE.toEntity(clientDto));

    }
    @GetMapping(value = "/{id}")
    public ClientDto getClientById( @PathVariable(name = "id") Long id ) {
        Client client = clientService.getClientById(id);
        return ClientMapper.INSTANCE.toDTO(client);
    }
    @GetMapping(value = "/clients")
    public List<ClientDto> getAllClients() {
        return ClientMapper.INSTANCE.toListDto(clientService.getAllClient());
    }
    @DeleteMapping(value = "/{id}")
    public void deleteClientById ( @PathVariable(name = "id") Long id ) {
        clientService.deleteClientById(id);
    }
}
