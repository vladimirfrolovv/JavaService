package com.example.RestClientService.controllers;

import com.example.RestClientService.model.dto.ClientDto;
import com.example.RestClientService.model.entity.Client;
import com.example.RestClientService.model.mapper.ClientMapper;
import com.example.RestClientService.services.ClientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class ClientControllerTests {

    private ClientController clientController;
    private ClientService clientService;

    @BeforeEach
    public void setUp() {
        clientService = mock(ClientService.class);
        clientController = new ClientController(clientService);
    }
    @Test
    public void testCreateNewClient() {
        Client client = new Client(1L,"vova", "vl@mail.ru", "1234");
        ClientDto clientDto = ClientMapper.INSTANCE.toDTO(client);
        clientController.createNewClient(clientDto);
        Mockito.verify(clientService, Mockito.times(1)).createClient(client);
    }

    @Test
    public void testGetClientById() {
        Client client = new Client(1L,"vova", "vl@mail.ru", "1234");
        when(clientService.getClientById(1L)).thenReturn(Optional.of(client));

        ResponseEntity<ClientDto> responseEntity = clientController.getClientById(1L);

        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        ClientDto clientDto = responseEntity.getBody();
        Assertions.assertEquals(1L, clientDto.getId());
        Assertions.assertEquals("vova", clientDto.getLogin());
        Assertions.assertEquals("vl@mail.ru", clientDto.getEmail());
        Assertions.assertEquals("1234", clientDto.getPassword());
        Mockito.verify(clientService,Mockito.times(1)).getClientById(1L);
    }

    @Test
    public void testGetClientByIdNotFound() {
        Long clientId = 1L;

        when(clientService.getClientById(clientId)).thenReturn(Optional.empty());
        ResponseEntity<ClientDto> responseEntity = clientController.getClientById(clientId);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        Assertions.assertNull(responseEntity.getBody());
    }

    @Test
    public void testGetAllClientsSuccess() {
        List<Client> clients = new ArrayList<>();
        Client client1 = new Client(1L,"vova", "vl@mail.ru", "1234");
        Client client2 = new Client(1L,"alexey", "al@gmail.com", "5431");
        when(clientService.getAllClient()).thenReturn(List.of(client1,client2));

        List<ClientDto> clientDtos = clientController.getAllClients();
        Assertions.assertNotNull(clientDtos);
        Assertions.assertEquals(clientDtos.get(0).getLogin(),"vova");
        Assertions.assertEquals(clientDtos.get(1).getLogin(),"alexey");
        Assertions.assertEquals(clientDtos.size(), 2);
        Mockito.verify(clientService, Mockito.times(1)).getAllClient();
    }

    @Test
    public void testDeleteClientById_Success() {
        Client client = new Client(1L,"vova", "vl@mail.ru", "1234");
        ClientDto clientDto = ClientMapper.INSTANCE.toDTO(client);
        clientController.deleteClientById(1L);
        Mockito.verify(clientService,Mockito.times(1)).deleteClientById(1L);
    }

    @Test
    public void testChangeClientDataSuccess() {
        Client client = new Client(1L,"vova", "vl@mail.ru", "1234");
        ClientDto clientDto = ClientMapper.INSTANCE.toDTO(client);

       clientController.changeClientData(clientDto, 1L);
       Mockito.verify(clientService, Mockito.times(1)).changeClientData(client, 1L);

        // Добавьте проверки, если нужно
    }

    @Test
    public void testGetClientByEmailSuccess() {
        String email = "example@email.com";
        Client client = new Client();
        client.setEmail(email);

        when(clientService.getClientByEmail(email)).thenReturn(Optional.of(client));

        ResponseEntity<ClientDto> responseEntity = clientController.getClientByEmail(email);

        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        ClientDto clientDto = responseEntity.getBody();
        Assertions.assertNotNull(clientDto);
        Assertions.assertEquals(email, clientDto.getEmail());
    }

    @Test
    public void testGetClientByEmailNotFound() {
        String email = "nasffasgsags@email.com";
        when(clientService.getClientByEmail(email)).thenReturn(Optional.empty());

        ResponseEntity<ClientDto> responseEntity = clientController.getClientByEmail(email);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        Assertions.assertNull(responseEntity.getBody());
    }
}

