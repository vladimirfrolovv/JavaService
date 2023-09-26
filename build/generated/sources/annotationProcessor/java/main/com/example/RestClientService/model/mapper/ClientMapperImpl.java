package com.example.RestClientService.model.mapper;

import com.example.RestClientService.model.dto.ClientDto;
import com.example.RestClientService.model.entity.Client;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-26T19:14:40+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.3.jar, environment: Java 17.0.8.1 (Private Build)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientDto toDTO(Client entity) {
        if ( entity == null ) {
            return null;
        }

        ClientDto clientDto = new ClientDto();

        clientDto.setId( entity.getId() );
        clientDto.setLogin( entity.getLogin() );
        clientDto.setEmail( entity.getEmail() );
        clientDto.setPassword( entity.getPassword() );

        return clientDto;
    }

    @Override
    public Client toEntity(ClientDto dto) {
        if ( dto == null ) {
            return null;
        }

        Client client = new Client();

        client.setId( dto.getId() );
        client.setLogin( dto.getLogin() );
        client.setEmail( dto.getEmail() );
        client.setPassword( dto.getPassword() );

        return client;
    }

    @Override
    public List<ClientDto> toListDto(List<Client> clients) {
        if ( clients == null ) {
            return null;
        }

        List<ClientDto> list = new ArrayList<ClientDto>( clients.size() );
        for ( Client client : clients ) {
            list.add( toDTO( client ) );
        }

        return list;
    }
}
