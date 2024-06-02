package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.activo.Activo;
import com.example.demo.models.activo.ActivosServiceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;


@RestController

public class ActivosController {

    @Autowired
    private ActivosServiceIMPL activosServiceIMPL;

    /* @PostMapping("/crearActivo")
    public  ResponseEntity crearActivo(@RequestBody Activo activo) {

        Activo nueActivo = this.activosServiceIMPL.save(activo);
        return new ResponseEntity<>(nueActivo, HttpStatus.OK);
    }


    @GetMapping("/obtenerActivos")
    public ResponseEntity obtenerActivos() {
        return new ResponseEntity<>(this.activosServiceIMPL.findAll(), HttpStatus.OK);
    }

    @PostMapping("/crearCategoria")
    public ResponseEntity crearCategoria(@RequestBody Categoria categoria) {
        return new ResponseEntity<>(this.categoriasServiceIMPL.save(categoria), HttpStatus.OK);
    }

    @PutMapping("/actualizarCategoria")
    public ResponseEntity actualizarCategoria(@RequestBody Categoria categoria) {
        return new ResponseEntity<>(this.categoriasServiceIMPL.update(categoria), HttpStatus.OK);
    } */

    @QueryMapping
    public List<Activo> allActivos() {
        return this.activosServiceIMPL.findAll();
    }

    @QueryMapping
    public Activo activosById(@Argument String id) {
        return this.activosServiceIMPL.findById(id);
    }

    @MutationMapping
    public Activo addActivo(@Argument Activo activo) {
        /* System.out.println(activo.toString()); */
        return this.activosServiceIMPL.save(activo);
    }

    @MutationMapping
    public Activo updateActivo(@Argument Activo activo) {
        return this.activosServiceIMPL.update(activo);
    }

    @QueryMapping
    public String deleteActivo(@Argument String id) {
        boolean isDelete = this.activosServiceIMPL.delete(id);
        return (isDelete) ? "Activo eliminado" : "No se pudo eliminar el activo";
    }


    /* record ActivoInput(String id,String nombre) {} */
}
