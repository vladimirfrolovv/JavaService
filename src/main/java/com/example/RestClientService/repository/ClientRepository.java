package com.example.RestClientService.repository;

import com.example.RestClientService.model.entity.Client;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Hidden
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findClientByEmail ( String email );
}
