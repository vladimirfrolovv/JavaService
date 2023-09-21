package com.example.javaservice.service;

import com.example.javaservice.model.entity.Client;

import java.util.List;

public interface ClientService {
    void createClient ( Client client );

    void authenticationClient ( String login, String password );
    Client getClientById (Long id);
    List<Client> getAllClient();
    boolean deleteClientById(Long id);

}
