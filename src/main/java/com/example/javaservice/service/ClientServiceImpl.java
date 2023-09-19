package com.example.javaservice.service;

import com.example.javaservice.model.dto.ClientDto;
import com.example.javaservice.model.entity.ClientEntity;
import com.example.javaservice.repisotory.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    public void createClient( ClientEntity clientEntity ) {
        clientRepository.save(clientEntity);
    }


    @Override
    public void createClient ( ClientEntity clientEntity ) {

    }

    public void authenticationClient( String login, String password) {}

    @Override
    public void uploadImage ( ) {

    }

    @Override
    public void getImagesInformation ( ) {

    }

}
