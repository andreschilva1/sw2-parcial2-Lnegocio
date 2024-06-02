package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.categoria.Categoria;
import com.example.demo.models.categoria.CategoriasServiceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;


@RestController

public class CategoriasController {

    @Autowired
    private CategoriasServiceIMPL categoriasServiceIMPL;

    @QueryMapping
    public List<Categoria> allCategorias() {
        return this.categoriasServiceIMPL.findAll();
    }

    @QueryMapping
    public Categoria categoriaById(@Argument String id) {
        return this.categoriasServiceIMPL.findById(id);
    }

    @MutationMapping
    public Categoria addCategoria(@Argument Categoria categoria) {
        return this.categoriasServiceIMPL.save(categoria);
    }

    @MutationMapping
    public Categoria updateCategoria(@Argument Categoria categoria) {
        return this.categoriasServiceIMPL.update(categoria);
    }

    @QueryMapping
    public String deleteCategoria(@Argument String id) {
        boolean isDelete = this.categoriasServiceIMPL.delete(id);
        return (isDelete) ? "categoria eliminada" : "No se pudo eliminar la categoria";
    }

}
