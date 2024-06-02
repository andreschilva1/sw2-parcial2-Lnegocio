package com.example.demo.models.fabricante;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FabricantesServiceIMPL {

    @Autowired
    private FabricantesRepo fabricantesRepo;

    public Fabricante save(Fabricante fabricante) {
        return this.fabricantesRepo.save(fabricante);
    }

    public Fabricante findById(String id) {
        return this.fabricantesRepo.findById(id).orElse(null);
    }

    public List<Fabricante> findAll() {
        return this.fabricantesRepo.findAll();
    }

    public Fabricante update(Fabricante fabricante) {
        return this.fabricantesRepo.save(fabricante);
    }

    public boolean delete(String id) {
        this.fabricantesRepo.deleteById(id);
        Optional<Fabricante> fabricante = this.fabricantesRepo.findById(id);
        return fabricante.isEmpty();
    }


    

}
