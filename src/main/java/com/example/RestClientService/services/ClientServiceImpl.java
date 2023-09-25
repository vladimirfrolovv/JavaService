package com.example.RestClientService.services;

import com.example.RestClientService.model.entity.Client;
import com.example.RestClientService.repisotory.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Override
    public void createClient ( Client client ) {
        clientRepository.save(client);
    }
    @Override
    public Optional<Client> getClientById ( Long id ) {
        return clientRepository.findById(id);
    }

    @Override
    public List<Client> getAllClient ( ) {
        return clientRepository.findAll();
    }

    @Override
    public boolean deleteClientById ( Long id ) {
        if (clientRepository.existsById(id)) {
            clientRepository.delete(clientRepository.getReferenceById(id));
            return true;
        }
        return false;
    }

    @Override
    public boolean changeClientData ( Client client, Long id ) {
        if (clientRepository.existsById(id)) {
            client.setId(id);
            clientRepository.save(client);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Client> getClientByEmail ( String email ) {
        return clientRepository.findClientByEmail(email);
    }

}
