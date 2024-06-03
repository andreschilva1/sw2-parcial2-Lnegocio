package com.example.demo.models.departamento;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartamentosRepo extends MongoRepository<Departamento, String>{
    
}
