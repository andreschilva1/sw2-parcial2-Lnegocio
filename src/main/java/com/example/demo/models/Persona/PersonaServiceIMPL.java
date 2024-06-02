package com.example.demo.models.Persona;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class PersonaServiceIMPL {

    @Autowired
    private PersonaRepo personasRepo;

    public Persona save(Persona persona) {
        return this.personasRepo.save(persona);
    }

    public Persona findById(String id) {
        return this.personasRepo.findById(id).orElse(null);
    }

    public List<Persona> findAll() {
        return this.personasRepo.findAll();
    }

    public Persona update(Persona persona) {
        return this.personasRepo.save(persona);
    }

    public boolean delete(String id) {
        this.personasRepo.deleteById(id);
        Optional<Persona> activo = this.personasRepo.findById(id);
        System.out.println("Activo: " + activo);
        return activo.isEmpty();
    }


    

}
