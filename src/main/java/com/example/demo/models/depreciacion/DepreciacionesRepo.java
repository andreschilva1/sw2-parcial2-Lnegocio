package com.example.demo.models.depreciacion;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepreciacionesRepo extends MongoRepository<Depreciacion, String>{
    
}
