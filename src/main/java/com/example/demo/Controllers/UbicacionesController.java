package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.ubicacion.Ubicacion;
import com.example.demo.models.ubicacion.UbicacionesServiceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;


@RestController

public class UbicacionesController {

    @Autowired
    private UbicacionesServiceIMPL ubicacionesServiceIMPL;

    @QueryMapping
    public List<Ubicacion> allUbicaciones() {
        return this.ubicacionesServiceIMPL.findAll();
    }

    @QueryMapping
    public Ubicacion ubicacionById(@Argument String id) {
        return this.ubicacionesServiceIMPL.findById(id);
    }

    @MutationMapping
    public Ubicacion addUbicacion(@Argument Ubicacion ubicacion) {
        return this.ubicacionesServiceIMPL.save(ubicacion);
    }

    @MutationMapping
    public Ubicacion updateUbicacion(@Argument Ubicacion ubicacion) {
        return this.ubicacionesServiceIMPL.update(ubicacion);
    }

    @QueryMapping
    public String deleteUbicacion(@Argument String id) {
        boolean isDelete = this.ubicacionesServiceIMPL.delete(id);
        return (isDelete) ? "ubicacion eliminada" : "No se pudo eliminar la ubicacion";
    }

}
