package com.example.RestClientService.services;

import com.example.RestClientService.model.entity.Client;
import com.example.RestClientService.repository.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClientServiceImplTests {
    private ClientService clientService;

    private ClientRepository clientRepository;

    @BeforeEach
    public void setUp ( ) {
        clientRepository = mock(ClientRepository.class);
        clientService = new ClientServiceImpl(clientRepository);
        when(clientRepository.findById(1L)).thenReturn(Optional.of(new Client(1L, "vova", "vl@mail.ru", "1234")));
        when(clientRepository.findById(2L)).thenReturn(Optional.empty());
        when(clientRepository.findClientByEmail("vl@mail.ru")).thenReturn(Optional.of(new Client(1L, "vova", "vl@mail.ru", "1234")));
        when(clientRepository.findClientByEmail("nonexistent@email.com")).thenReturn(Optional.empty());
        when(clientRepository.existsById(1L)).thenReturn(true);
        when(clientRepository.existsById(2L)).thenReturn(false);
        when(clientRepository.findAll()).thenReturn(List.of(new Client(1L, "vova", "vl@mail.ru", "1234"),
                new Client(2L, "alexey", "al@gmail.com", "5431")));
    }

    @Test
    public void testGetClientById ( ) {
        Optional<Client> client = clientService.getClientById(1L);
        Assertions.assertEquals(1L, client.get().getId());
        Assertions.assertEquals("vova", client.get().getLogin());
        Assertions.assertEquals("vl@mail.ru", client.get().getEmail());
        Assertions.assertEquals("1234", client.get().getPassword());
        Optional<Client> nonExistentClient = clientService.getClientById(2L);
        Assertions.assertEquals(Optional.empty(), nonExistentClient);
    }

    @Test
    public void testGetAllClient ( ) {
        List<Client> clients = clientService.getAllClient();
        Assertions.assertEquals(2, clients.size());
        Assertions.assertEquals("vova", clients.get(0).getLogin());
        Assertions.assertEquals("alexey", clients.get(1).getLogin());
        Mockito.verify(clientRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void testDeleteClientById ( ) {
        boolean deleted = clientService.deleteClientById(1L);
        Assertions.assertTrue(deleted);
        boolean notDeleted = clientService.deleteClientById(2L);
        Assertions.assertFalse(notDeleted);
    }

    @Test
    public void testChangeClientData ( ) {
        Client updatedClient = new Client(1L, "newVova", "new_vl@mail.ru", "new1234");
        boolean updated = clientService.changeClientData(updatedClient, 1L);
        Assertions.assertTrue(updated);
        boolean notUpdated = clientService.changeClientData(updatedClient, 2L);
        Assertions.assertFalse(notUpdated);
    }

    @Test
    public void testGetClientByEmail ( ) {
        Optional<Client> client = clientService.getClientByEmail("vl@mail.ru");
        Assertions.assertEquals(1L, client.get().getId());
        Assertions.assertEquals("vova", client.get().getLogin());
        Optional<Client> nonExistentClient = clientService.getClientByEmail("nonexistent@email.com");
        Assertions.assertEquals(Optional.empty(), nonExistentClient);
    }
}
