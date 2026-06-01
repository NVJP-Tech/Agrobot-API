package com.fiap.agrobot.controller;

import com.fiap.agrobot.dto.PlantaDTO;
import com.fiap.agrobot.service.PlantaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/plantas")
public class PlantaController {

    @Autowired
    private PlantaService service;

    @GetMapping
    public ResponseEntity<List<PlantaDTO>> getCatalogo() {
        return ResponseEntity.ok(service.listarCatalogo());
    }
}
