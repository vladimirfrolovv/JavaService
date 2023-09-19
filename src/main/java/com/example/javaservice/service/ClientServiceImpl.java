package com.example.javaservice.service;

import com.example.javaservice.model.entity.Client;
import com.example.javaservice.repisotory.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;


    @Override
    public void createClient ( Client client ) {
        clientRepository.save(client);
    }

    @Override
    public void authenticationClient ( String login, String password ) {

    }
}
