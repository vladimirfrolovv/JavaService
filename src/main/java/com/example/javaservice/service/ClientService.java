package com.example.javaservice.service;

import com.example.javaservice.model.entity.Client;

public interface ClientService {
    void createClient ( Client client );

    void authenticationClient ( String login, String password );


}
