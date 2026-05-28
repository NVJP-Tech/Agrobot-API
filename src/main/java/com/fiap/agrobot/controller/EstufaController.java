package com.fiap.agrobot.controller;

import com.fiap.agrobot.dto.EstufaDTO;
import com.fiap.agrobot.service.EstufaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/estufas")
public class EstufaController {

    @Autowired
    private EstufaService service;

    @GetMapping
    public ResponseEntity<List<EstufaDTO>> getStatus() {
        return ResponseEntity.ok(service.listarEstufasAtivas());
    }
}
