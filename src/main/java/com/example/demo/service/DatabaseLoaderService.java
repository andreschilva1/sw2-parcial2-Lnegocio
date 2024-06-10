package com.example.demo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.Document;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class DatabaseLoaderService {

    private final MongoTemplate mongoTemplate;
    private final ResourceLoader resourceLoader;

    public DatabaseLoaderService(MongoTemplate mongoTemplate, ResourceLoader resourceLoader) {
        this.mongoTemplate = mongoTemplate;
        this.resourceLoader = resourceLoader;
    }

    public void loadDatabase() {
        cargarCollection("activos");
        cargarCollection("personas");
        cargarCollection("categorias");
        cargarCollection("departamentos");
        cargarCollection("depreciaciones");
        cargarCollection("fabricantes");
        cargarCollection("modelos");
        cargarCollection("ubicaciones");

    }

    private void cargarCollection(String collectionName) {
        try {
            // Carga el archivo JSON
            InputStream is = resourceLoader.getResource("classpath:dataset/"+collectionName+".json").getInputStream();
            // Lee el archivo JSON como un array de JsonNode
            ObjectMapper mapper = new ObjectMapper();
            JsonNode arrayNode = mapper.readTree(is);
            if (arrayNode.isArray()) {
                for (JsonNode jsonNode : arrayNode) {
                    // Convierte el JsonNode a un Document de MongoDB
                    Document document = Document.parse(jsonNode.toString());
                    // Inserta el Document en la base de datos
                    mongoTemplate.insert(document, collectionName);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al cargar los datos", e);
        }
    }
}