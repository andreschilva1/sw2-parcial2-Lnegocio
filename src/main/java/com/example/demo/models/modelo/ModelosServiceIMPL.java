package com.example.demo.models.modelo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ModelosServiceIMPL {

    @Autowired
    private ModelosRepo modelosRepo;

    public Modelo save(Modelo modelo) {
        return this.modelosRepo.save(modelo);
    }

    public Modelo findById(String id) {
        return this.modelosRepo.findById(id).orElse(null);
    }

    public List<Modelo> findAll() {
        return this.modelosRepo.findAll();
    }

    public Modelo update(Modelo modelo) {
        return this.modelosRepo.save(modelo);
    }

    public boolean delete(String id) {
        this.modelosRepo.deleteById(id);
        Optional<Modelo> modelo = this.modelosRepo.findById(id);
        return modelo.isEmpty();
    }


    

}
