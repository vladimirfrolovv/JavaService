package com.example.RestClientService.controllers;

import com.example.RestClientService.model.dto.ClientDto;
import com.example.RestClientService.model.entity.Client;
import com.example.RestClientService.model.mapper.ClientMapper;
import com.example.RestClientService.services.ClientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Slf4j
@Tag(name = "Clients", description = "")
@RequestMapping(path = "api/clients")
public class ClientController {
    private final ClientService clientService;

    @PostMapping
    public void createNewClient ( @RequestBody ClientDto clientDto ) {
        clientService.createClient(ClientMapper.INSTANCE.toEntity(clientDto));

    }
    @GetMapping(value = "{clientId}")
    public ResponseEntity<ClientDto> getClientById ( @PathVariable(name = "clientId") Long id ) {
        Optional<Client> client = clientService.getClientById(id);
        if (client.isEmpty()) {
            log.error("Client not Found");
            return ResponseEntity.notFound().build();
        }
        log.info("Client: " + client.get().toString());
        return ResponseEntity.ok(ClientMapper.INSTANCE.toDTO(client.get()));
    }

    @GetMapping
    public List<ClientDto> getAllClients ( ) {
        return ClientMapper.INSTANCE.toListDto(clientService.getAllClient());
    }

    @DeleteMapping(value = "{clientId}")
    public void deleteClientById ( @PathVariable(name = "clientId") Long id ) {
        if (clientService.deleteClientById(id)) {
            log.info("Client deleted");
        } else {
            log.error("Client not found");
        }
    }

    @PutMapping(value = "{clientId}")
    public void changeClientData ( @RequestBody ClientDto clientDto, @PathVariable(name = "clientId") Long id ) {
        if (clientService.changeClientData(ClientMapper.INSTANCE.toEntity(clientDto), id)) {
            log.info("Client updated");
        } else {
            log.error("Client not found");
        }
    }
    @GetMapping(value= "{clientEmail}")
    public ResponseEntity<ClientDto> getClientByEmail( @PathVariable(name = "clientEmail") String email ) {
        Optional<Client> client = clientService.getClientByEmail(email);
        if (client.isEmpty()) {
            log.error("Client not Found");
            return ResponseEntity.notFound().build();
        }
        log.info("Client: " + client.get().toString());
        return ResponseEntity.ok(ClientMapper.INSTANCE.toDTO(client.get()));
    }
}
