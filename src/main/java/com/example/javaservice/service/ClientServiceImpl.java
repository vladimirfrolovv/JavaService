package com.example.javaservice.service;

import com.example.javaservice.model.entity.Client;
import com.example.javaservice.repisotory.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    private PasswordEncoder passwordEncoder;
    @Override
    public void createClient ( Client client ) {
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        clientRepository.save(client);
    }

    @Override
    public void authenticationClient ( String login, String password ) {

    }
    @Override
    public Client getClientById (Long id) {
        return clientRepository.getReferenceById(id);
    }
    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }
    @Override
    public boolean deleteClientById(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.delete(clientRepository.getReferenceById(id));
            return true;
        }
        return false;
    }
    @Override
    public boolean changeClientData(Client client, Long id) {
        if (clientRepository.existsById(id)) {
            client.setId(id);
            clientRepository.save(client);
            return true;
        }
        return false;
    }

}
