package com.example.demo.models.categoria;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoriasRepo extends MongoRepository<Categoria, String>{
    
}
