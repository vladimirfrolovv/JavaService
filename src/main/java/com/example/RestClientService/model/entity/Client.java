package com.example.RestClientService.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clients")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String login;
    String email;
    String password;
}
