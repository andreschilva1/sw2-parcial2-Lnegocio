package com.example.demo.models.depreciacion;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "depreciaciones")

public class Depreciacion {
    // Atributos
    @Id
    private String id;
    private String meses;
    private String valorMinimo;
    
    
}
