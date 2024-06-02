package com.example.demo.models.ubicacion;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UbicacionesRepo extends MongoRepository<Ubicacion, String>{
    
}
