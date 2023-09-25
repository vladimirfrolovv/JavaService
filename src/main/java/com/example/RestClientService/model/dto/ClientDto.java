package com.example.RestClientService.model.dto;

import lombok.*;

@Getter
@Setter
public class ClientDto {
    Long id;
    String login;
    String email;
    String password;
}
