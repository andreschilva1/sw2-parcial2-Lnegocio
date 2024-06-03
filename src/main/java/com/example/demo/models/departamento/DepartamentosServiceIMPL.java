package com.example.demo.models.departamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class DepartamentosServiceIMPL {

    @Autowired
    private DepartamentosRepo personasRepo;

    public Departamento save(Departamento departamento) {
        return this.personasRepo.save(departamento);
    }

    public Departamento findById(String id) {
        return this.personasRepo.findById(id).orElse(null);
    }

    public List<Departamento> findAll() {
        return this.personasRepo.findAll();
    }

    public Departamento update(Departamento departamento) {
        return this.personasRepo.save(departamento);
    }

    public boolean delete(String id) {
        this.personasRepo.deleteById(id);
        Optional<Departamento> activo = this.personasRepo.findById(id);
        System.out.println("Activo: " + activo);
        return activo.isEmpty();
    }


    

}
