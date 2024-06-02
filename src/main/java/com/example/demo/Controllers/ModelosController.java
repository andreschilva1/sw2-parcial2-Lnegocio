package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.modelo.Modelo;
import com.example.demo.models.modelo.ModelosServiceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;


@RestController

public class ModelosController {

    @Autowired
    private ModelosServiceIMPL modelosServiceIMPL;

    @QueryMapping
    public List<Modelo> allModelos() {
        return this.modelosServiceIMPL.findAll();
    }

    @QueryMapping
    public Modelo modeloById(@Argument String id) {
        return this.modelosServiceIMPL.findById(id);
    }

    @MutationMapping
    public Modelo addModelo(@Argument Modelo modelo) {
        return this.modelosServiceIMPL.save(modelo);
    }

    @MutationMapping
    public Modelo updateModelo(@Argument Modelo modelo) {
        return this.modelosServiceIMPL.update(modelo);
    }

    @QueryMapping
    public String deleteModelo(@Argument String id) {
        boolean isDelete = this.modelosServiceIMPL.delete(id);
        return (isDelete) ? "modelo eliminado" : "No se pudo eliminar el modelo";
    }

}
