package com.example.RestClientServiceTests.controllersTests;

import com.example.RestClientService.controllers.ClientController;
import com.example.RestClientService.model.dto.ClientDto;
import com.example.RestClientService.model.entity.Client;
import com.example.RestClientService.services.ClientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
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
        ClientDto clientDto = new ClientDto();
        clientDto.setLogin("vova");
        clientDto.setEmail("vl@mail.ru");
        clientDto.setPassword("1234");

        doNothing().when(clientService).createClient(any(Client.class));

        clientController.createNewClient(clientDto);

        verify(clientService).createClient(argThat(client ->
                "vova".equals(client.getLogin()) &&
                        "vl@mail.ru".equals(client.getEmail()) &&
                        "1234".equals(client.getPassword())
        ));
    }

    @Test
    public void testGetClientById() {
        Long clientId = 1L;
        Client client = new Client();
        client.setId(clientId);
        client.setLogin("ivan");
        client.setEmail("iv@gmail.com");
        client.setPassword("5678");

        when(clientService.getClientById(clientId)).thenReturn(Optional.of(client));

        ResponseEntity<ClientDto> responseEntity = clientController.getClientById(clientId);

        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        ClientDto clientDto = responseEntity.getBody();
        Assertions.assertEquals(clientId, clientDto.getId());
        Assertions.assertEquals("ivan", clientDto.getLogin());
        Assertions.assertEquals("iv@gmail.com", clientDto.getEmail());
        Assertions.assertEquals("5678", clientDto.getPassword());
    }

    @Test
    public void testCreateNewClient_Success() {
        ClientDto clientDto = new ClientDto();
        clientDto.setLogin("vova");
        clientDto.setEmail("vl@mail.ru");
        clientDto.setPassword("1234");

        doNothing().when(clientService).createClient(any(Client.class));

        clientController.createNewClient(clientDto);

        // Добавьте проверки на успешное создание клиента, если нужно
    }


    @Test
    public void testGetClientById_Success() {
        Long clientId = 1L;
        Client client = new Client();
        client.setId(clientId);
        client.setLogin("ivan");
        client.setEmail("iv@gmail.com");
        client.setPassword("5678");

        when(clientService.getClientById(clientId)).thenReturn(Optional.of(client));

        ResponseEntity<ClientDto> responseEntity = clientController.getClientById(clientId);

        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        ClientDto clientDto = responseEntity.getBody();
        Assertions.assertNotNull(clientDto);
        Assertions.assertEquals(clientId, clientDto.getId());
        Assertions.assertEquals("ivan", clientDto.getLogin());
        Assertions.assertEquals("iv@gmail.com", clientDto.getEmail());
        Assertions.assertEquals("5678", clientDto.getPassword());
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
        // Подготовьте список клиентов и верните его из сервиса
        List<Client> clients = new ArrayList<>();
        // Добавьте клиентов в список
        when(clientService.getAllClient()).thenReturn(clients);

        List<ClientDto> clientDtos = clientController.getAllClients();

        // Проверьте, что список DTO не пустой и соответствует ожиданиям
        Assertions.assertNotNull(clientDtos);
        // Добавьте дополнительные проверки, если нужно
    }

    @Test
    public void testDeleteClientById_Success() {
        Long clientId = 1L;
        when(clientService.deleteClientById(clientId)).thenReturn(true);

        clientController.deleteClientById(clientId);

        // Добавьте проверки, если нужно
    }

    @Test
    public void testDeleteClientById_NotFound() {
        Long clientId = 1L;
        when(clientService.deleteClientById(clientId)).thenReturn(false);

        // Вызовите метод удаления и проверьте обработку, если клиент не найден
        clientController.deleteClientById(clientId);

        // Добавьте проверки, если нужно
    }

    @Test
    public void testChangeClientData_Success() {
        Long clientId = 1L;
        ClientDto clientDto = new ClientDto();
        clientDto.setLogin("newLogin");
        clientDto.setEmail("newEmail");
        clientDto.setPassword("newPassword");

        when(clientService.changeClientData(any(Client.class), eq(clientId))).thenReturn(true);

        clientController.changeClientData(clientDto, clientId);

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

