package com.example.javaservice.controller;

import com.example.javaservice.model.dto.ClientDto;
import com.example.javaservice.model.entity.Client;
import com.example.javaservice.model.mapper.ClientMapper;
import com.example.javaservice.service.ClientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Clients", description = "sad")
public class ClientController {
    private final ClientService clientService;

    @PostMapping(value = "/clients")
    public void createNewClient ( @RequestBody ClientDto clientDto ) {
        clientService.createClient( ClientMapper.INSTANCE.toEntity(clientDto));

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
    @PutMapping(value = "/{id}")
    public void changeClientData(@RequestBody ClientDto clientDto, @PathVariable (name = "id") Long id) {
            clientService.changeClientData(ClientMapper.INSTANCE.toEntity(clientDto), id);
    }
}
