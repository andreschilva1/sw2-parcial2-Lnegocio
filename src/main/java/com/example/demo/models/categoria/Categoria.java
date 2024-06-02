package com.example.demo.models.categoria;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "categorias")

public class Categoria {
    // Atributos
    @Id
    private String id;
    private String nombre;

}
