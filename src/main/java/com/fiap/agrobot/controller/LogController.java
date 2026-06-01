package com.fiap.agrobot.controller;

import com.fiap.agrobot.dto.LogDTO;
import com.fiap.agrobot.model.Log;
import com.fiap.agrobot.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    @Autowired
    private LogService service;

    @GetMapping
    public ResponseEntity<List<LogDTO>> getLogs() {
        return ResponseEntity.ok(service.listarAlertas());
    }

    @PostMapping("/sensor/{culId}")
    public ResponseEntity<LogDTO> receberDadosSensor(
                                                      @PathVariable Long culId,
                                                      @RequestParam String tipo,
                                                      @RequestParam Double valor) {
        return ResponseEntity.status(201).body(service.registrarLeitura(culId, tipo, valor));
    }
}
