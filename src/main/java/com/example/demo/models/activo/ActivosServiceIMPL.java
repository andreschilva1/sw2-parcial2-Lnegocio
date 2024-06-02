package com.example.demo.models.activo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class ActivosServiceIMPL {

    @Autowired
    private ActivosRepo activosRepo;

    public Activo save(Activo activos) {
        return this.activosRepo.save(activos);
    }

    public Activo findById(String id) {
        return this.activosRepo.findById(id).orElse(null);
    }

    public List<Activo> findAll() {
        return this.activosRepo.findAll();
    }

    public Activo update(Activo activos) {
        return this.activosRepo.save(activos);
    }

    public boolean delete(String id) {
        this.activosRepo.deleteById(id);
        Optional<Activo> activo = this.activosRepo.findById(id);
        System.out.println("Activo: " + activo);
        return activo.isEmpty();
    }


    

}
