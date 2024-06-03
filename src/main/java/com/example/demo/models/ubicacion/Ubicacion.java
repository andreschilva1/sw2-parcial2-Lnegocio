package com.example.demo.models.ubicacion;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "ubicaciones")

public class Ubicacion {
    // Atributos
    @Id
    private String id;
    private String nombre;
    private String direccion;

}
