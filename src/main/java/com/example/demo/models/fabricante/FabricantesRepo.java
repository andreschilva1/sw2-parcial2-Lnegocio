package com.example.demo.models.fabricante;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FabricantesRepo extends MongoRepository<Fabricante, String>{
    
}
