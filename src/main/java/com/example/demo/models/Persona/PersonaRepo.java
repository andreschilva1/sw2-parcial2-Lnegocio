package com.example.demo.models.Persona;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonaRepo extends MongoRepository<Persona, String>{
    
}
