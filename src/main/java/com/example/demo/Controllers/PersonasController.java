package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.persona.Persona;
import com.example.demo.models.persona.PersonaServiceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.annotation.Secured;


@RestController

public class PersonasController {

    @Autowired
    private PersonaServiceIMPL personasServiceIMPL;

    //@Secured("ROLE_ADMIN")
    @QueryMapping
    public List<Persona> allPersonas() {
        return this.personasServiceIMPL.findAll();
    }

    @QueryMapping
    public Persona personaById(@Argument String id) {
        return this.personasServiceIMPL.findById(id);
    }

    @MutationMapping
    public Persona addPersona(@Argument Persona persona) {
        /* System.out.println(persona.toString()); */
        return this.personasServiceIMPL.save(persona);
    }

    @MutationMapping
    public Persona updatePersona(@Argument Persona persona) {
        return this.personasServiceIMPL.update(persona);
    }

    @QueryMapping
    public String deletePersona(@Argument String id) {
        boolean isDelete = this.personasServiceIMPL.delete(id);
        return (isDelete) ? "Persona eliminada" : "No se pudo eliminar la persona";
    }


    /* record PersonaInput(String id,String nombre) {} */
}
