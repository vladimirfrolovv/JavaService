package com.example.javaservice.service;

import com.example.javaservice.model.entity.Client;
import com.example.javaservice.repisotory.ClientRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;


    @Override
    public void createClient ( Client client ) {
//        System.out.println(client.getPassword());
        clientRepository.save(client);
    }

    @Override
    public void authenticationClient ( String login, String password ) {

    }
    @Override
    public Client getClientById (Long id) {
        return clientRepository.getReferenceById(id);
    }
}
