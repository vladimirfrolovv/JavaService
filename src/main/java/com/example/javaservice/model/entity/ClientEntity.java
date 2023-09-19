package com.example.javaservice.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.data.relational.core.sql.In;

@Getter
@Entity
public class ClientEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
    String login;
    String email;
    String password;
    Boolean registered = false;

    public ClientEntity ( ) {}

    public ClientEntity ( String login, String email, String password ) {
        this.login = login;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString ( ) {
        return "ClientEntity{" +
                "login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setLogin ( String login ) {
        this.login = login;
    }

    public void setEmail ( String email ) {
        this.email = email;
    }

    public void setPassword ( String password ) {
        this.password = password;
    }

    public void setRegistered ( Boolean registered ) {
        this.registered = registered;
    }

}
