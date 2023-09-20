package com.example.javaservice.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "clients")
@Data
public class Client {
    @Id
//    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
//    @Column(name = "login")
    String login;
//    @Column(name = "email", nullable = false, unique = true)
    String email;
//    @Column(name = "password", nullable = false)
    String password;
//    @Column(name = "registered")
    Boolean registered = false;

}
