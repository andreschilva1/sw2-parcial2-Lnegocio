package com.example.demo.models.depreciacion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DepreciacionesIMPL {

    @Autowired
    private DepreciacionesRepo depreciacionesRepo;

    public Depreciacion save(Depreciacion depreciacion) {
        return this.depreciacionesRepo.save(depreciacion);
    }

    public Depreciacion findById(String id) {
        return this.depreciacionesRepo.findById(id).orElse(null);
    }

    public List<Depreciacion> findAll() {
        return this.depreciacionesRepo.findAll();
    }

    public Depreciacion update(Depreciacion depreciacion) {
        return this.depreciacionesRepo.save(depreciacion);
    }

    public boolean delete(String id) {
        this.depreciacionesRepo.deleteById(id);
        Optional<Depreciacion> depreciacion = this.depreciacionesRepo.findById(id);
        return depreciacion.isEmpty();
    }



}
