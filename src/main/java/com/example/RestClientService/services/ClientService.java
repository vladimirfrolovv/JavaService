package com.example.RestClientService.services;

import com.example.RestClientService.model.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    void createClient ( Client client );

    Optional<Client> getClientById ( Long id );

    List<Client> getAllClient ( );

    boolean deleteClientById ( Long id );

    boolean changeClientData ( Client client, Long id );

    Optional<Client> getClientByEmail ( String email );


}
