package com.fiap.agrobot.controller;

import com.fiap.agrobot.dto.CultivoDTO;
import com.fiap.agrobot.model.Cultivo;
import com.fiap.agrobot.service.CultivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cultivos")
public class CultivoController {

    @Autowired
    private CultivoService service;

    @GetMapping
    public ResponseEntity<List<CultivoDTO>> getAtivos() {
        return ResponseEntity.ok(service.listarAtivos());
    }

    @PostMapping("/{pltId}/{habId}/{astId}")
    public ResponseEntity<Cultivo> iniciar(@PathVariable Long pltId, @PathVariable Long habId, @PathVariable Long astId) {
        return ResponseEntity.status(201).body(service.salvar(pltId, habId, astId));
    }
}
