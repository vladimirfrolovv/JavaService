package com.example.javaservice.service;

import com.example.javaservice.model.dto.ClientDto;
import com.example.javaservice.model.entity.ClientEntity;

public interface ClientService {
    void createClient( ClientEntity clientEntity);
    void authenticationClient(String login, String password);
   //TODO Как приннимается картинка, мб как url
    void uploadImage();
    void getImagesInformation();


}
