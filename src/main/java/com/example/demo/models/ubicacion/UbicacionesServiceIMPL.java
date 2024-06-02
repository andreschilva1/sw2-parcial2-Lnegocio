package com.example.demo.models.ubicacion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UbicacionesServiceIMPL {

    @Autowired
    private UbicacionesRepo ubicacionesRepo;

    public Ubicacion save(Ubicacion ubicacion) {
        return this.ubicacionesRepo.save(ubicacion);
    }

    public Ubicacion findById(String id) {
        return this.ubicacionesRepo.findById(id).orElse(null);
    }

    public List<Ubicacion> findAll() {
        return this.ubicacionesRepo.findAll();
    }

    public Ubicacion update(Ubicacion ubicacion) {
        return this.ubicacionesRepo.save(ubicacion);
    }

    public boolean delete(String id) {
        this.ubicacionesRepo.deleteById(id);
        Optional<Ubicacion> ubicacion = this.ubicacionesRepo.findById(id);
        return ubicacion.isEmpty();
    }


}
