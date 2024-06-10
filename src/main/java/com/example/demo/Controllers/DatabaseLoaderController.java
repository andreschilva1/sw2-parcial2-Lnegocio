package com.example.demo.Controllers;

import org.springframework.http.ResponseEntity;

import com.example.demo.service.DatabaseLoaderService;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;


@RestController
public class DatabaseLoaderController {

    private final DatabaseLoaderService databaseLoaderService;

    public DatabaseLoaderController(DatabaseLoaderService databaseLoaderService) {
        this.databaseLoaderService = databaseLoaderService;
    }

    @GetMapping("/cargarBaseDeDatos")
    public ResponseEntity<String> loadDatabase() {
        databaseLoaderService.loadDatabase();
        return ResponseEntity.ok("Base de datos cargada");
    }
}