package com.example.demo.models.activo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActivosRepo extends MongoRepository<Activo, String>{
    
}
