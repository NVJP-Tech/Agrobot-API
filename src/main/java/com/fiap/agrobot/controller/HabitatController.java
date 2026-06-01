package com.fiap.agrobot.controller;

import com.fiap.agrobot.dto.HabitatDTO;
import com.fiap.agrobot.model.Habitat;
import com.fiap.agrobot.service.HabitatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habitat")
public class HabitatController {

    @Autowired
    private HabitatService service;

    @GetMapping
    public ResponseEntity<List<HabitatDTO>> getStatus() {
        return ResponseEntity.ok(service.listarEstufasAtivas());
    }


    @PutMapping("/{id}")
    public ResponseEntity<HabitatDTO> atualizar(@PathVariable Long id, @RequestBody Habitat habitat) {
        return ResponseEntity.ok(service.atualizar(id, habitat));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content
    }
}
