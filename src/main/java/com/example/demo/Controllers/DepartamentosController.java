package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.departamento.Departamento;
import com.example.demo.models.departamento.DepartamentosServiceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;


@RestController

public class DepartamentosController {

    @Autowired
    private DepartamentosServiceIMPL departamentosServiceIMPL;

    @QueryMapping
    public List<Departamento> allDepartamentos() {
        return this.departamentosServiceIMPL.findAll();
    }

    @QueryMapping
    public Departamento departamentoById(@Argument String id) {
        return this.departamentosServiceIMPL.findById(id);
    }

    @MutationMapping
    public Departamento addDepartamento(@Argument Departamento departamento) {
        return this.departamentosServiceIMPL.save(departamento);
    }

    @MutationMapping
    public Departamento updateDepartamento(@Argument Departamento departamento) {
        return this.departamentosServiceIMPL.update(departamento);
    }

    @QueryMapping
    public String deleteDepartamento(@Argument String id) {
        boolean isDelete = this.departamentosServiceIMPL.delete(id);
        return (isDelete) ? "departamento eliminado" : "No se pudo eliminar el departamento";
    }

}
