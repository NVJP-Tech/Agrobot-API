package com.fiap.agrobot.controller;

import com.fiap.agrobot.dto.AstronautaDTO;
import com.fiap.agrobot.model.Astronauta;
import com.fiap.agrobot.service.AstronautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/astronautas")
public class AstronautaController {

    @Autowired
    private AstronautaService service;

    @GetMapping
    public ResponseEntity<List<AstronautaDTO>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PostMapping
    public ResponseEntity<AstronautaDTO> cadastrar(@RequestBody Astronauta astronauta) {
        return ResponseEntity.status(201).body(service.salvar(astronauta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AstronautaDTO> atualizar(@PathVariable Long id, @RequestBody Astronauta astronauta) {
        return ResponseEntity.ok(service.atualizar(id, astronauta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
