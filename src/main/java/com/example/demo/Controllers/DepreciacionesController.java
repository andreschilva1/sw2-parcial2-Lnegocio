package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.depreciacion.Depreciacion;
import com.example.demo.models.depreciacion.DepreciacionesIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;


@RestController

public class DepreciacionesController {

    @Autowired
    private DepreciacionesIMPL depreciacionesIMPL;

    @QueryMapping
    public List<Depreciacion> allDepreciaciones() {
        return this.depreciacionesIMPL.findAll();
    }

    @QueryMapping
    public Depreciacion depreciacionById(@Argument String id) {
        return this.depreciacionesIMPL.findById(id);
    }

    @MutationMapping
    public Depreciacion addDepreciacion(@Argument Depreciacion depreciacion) {
        return this.depreciacionesIMPL.save(depreciacion);
    }

    @MutationMapping
    public Depreciacion updateDepreciacion(@Argument Depreciacion depreciacion) {
        return this.depreciacionesIMPL.update(depreciacion);
    }

    @QueryMapping
    public String deleteDepreciacion(@Argument String id) {
        boolean isDelete = this.depreciacionesIMPL.delete(id);
        return (isDelete) ? "depreciacion eliminada" : "No se pudo eliminar la depreciacion";
    }

}
