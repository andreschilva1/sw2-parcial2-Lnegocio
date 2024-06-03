package com.example.demo.models.persona;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.models.departamento.Departamento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "personas")

public class Persona {
    // Atributos
    @Id
    private String id;
    private String nombre;
    private String email;
    private String telefono;
    private String ci;

    @DBRef
    private Departamento departamento;

}
