package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.fabricante.Fabricante;
import com.example.demo.models.fabricante.FabricantesServiceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;


@RestController

public class FabricantesController {

    @Autowired
    private FabricantesServiceIMPL fabricantesServiceIMPL;

    @QueryMapping
    public List<Fabricante> allFabricantes() {
        return this.fabricantesServiceIMPL.findAll();
    }

    @QueryMapping
    public Fabricante fabricanteById(@Argument String id) {
        return this.fabricantesServiceIMPL.findById(id);
    }

    @MutationMapping
    public Fabricante addFabricante(@Argument Fabricante fabricante) {
        return this.fabricantesServiceIMPL.save(fabricante);
    }

    @MutationMapping
    public Fabricante updateFabricante(@Argument Fabricante fabricante) {
        return this.fabricantesServiceIMPL.update(fabricante);
    }

    @QueryMapping
    public String deleteFabricante(@Argument String id) {
        boolean isDelete = this.fabricantesServiceIMPL.delete(id);
        return (isDelete) ? "fabricante eliminado" : "No se pudo eliminar el fabricante";
    }

}
