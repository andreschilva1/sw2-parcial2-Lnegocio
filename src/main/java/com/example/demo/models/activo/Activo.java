package com.example.demo.models.activo;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.models.depreciacion.Depreciacion;
import com.example.demo.models.modelo.Modelo;
import com.example.demo.models.persona.Persona;
import com.example.demo.models.ubicacion.Ubicacion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "activos")

public class Activo {
    // Atributos
    @Id
    private String id;
    private String nombre;
    private String serial;
    private String estado;
    private Date ultimaAsignacion;
    private Date ultimaDesasignacion;
    private Date fechaCompra;
    private String valorCompra;
    private String valorActual;
    

    @DBRef
    private Persona asignadoA;

    @DBRef
    private Modelo modelo;
    @DBRef
    private Depreciacion depreciacion;
    @DBRef
    private Ubicacion ubicacion;

}
