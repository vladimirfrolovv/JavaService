package com.example.javaservice.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.descriptor.jdbc.TimestampWithTimeZoneJdbcType;

import java.sql.Timestamp;
import java.util.Objects;

@Getter
@Setter
public class ClientDto {
    Long id;
    String login;
    String email;
    String password;
    Boolean registered;

    @Override
    public String toString ( ) {
        return "ClientDto{" +
                "id=" + id +
                ", name='" + login + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
