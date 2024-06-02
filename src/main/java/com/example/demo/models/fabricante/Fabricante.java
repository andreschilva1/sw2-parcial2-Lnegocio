package com.example.demo.models.fabricante;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "fabricantes")

public class Fabricante {
    // Atributos
    @Id
    private String id;
    private String nombre;

}
