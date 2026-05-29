package com.fiap.agrobot.controller;

import com.fiap.agrobot.dto.HabitatDTO;
import com.fiap.agrobot.service.HabitatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
