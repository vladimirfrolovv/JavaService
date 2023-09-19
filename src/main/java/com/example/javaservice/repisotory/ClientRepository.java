package com.example.javaservice.repisotory;

import com.example.javaservice.model.entity.ClientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<ClientEntity,Long> {

}
