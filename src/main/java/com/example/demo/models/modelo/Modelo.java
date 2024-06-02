package com.example.demo.models.modelo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.models.categoria.Categoria;
import com.example.demo.models.fabricante.Fabricante;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "modelos")

public class Modelo {
    // Atributos
    @Id
    private String id;
    private String nombre;
    
    @DBRef
    private Fabricante fabricante;
    @DBRef
    private Categoria  categoria;
    
    
}
