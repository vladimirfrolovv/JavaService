package com.example.javaservice.model.dto;

import lombok.Data;

@Data
public class ClientDto {
    Long id;
    String login;
    String email;
    String password;
    Boolean registered;
    

}
