package com.example.demo.models.categoria;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CategoriasServiceIMPL {

    @Autowired
    private CategoriasRepo categoriasRepo;

    public Categoria save(Categoria categoria) {
        return this.categoriasRepo.save(categoria);
    }

    public Categoria findById(String id) {
        return this.categoriasRepo.findById(id).orElse(null);
    }

    public List<Categoria> findAll() {
        return this.categoriasRepo.findAll();
    }

    public Categoria update(Categoria categoria) {
        return this.categoriasRepo.save(categoria);
    }

    public boolean delete(String id) {
        this.categoriasRepo.deleteById(id);
        Optional<Categoria> categoria = this.categoriasRepo.findById(id);
        return categoria.isEmpty();
    }


    

}
