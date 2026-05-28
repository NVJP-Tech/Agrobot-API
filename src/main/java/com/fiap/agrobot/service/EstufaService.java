package com.fiap.agrobot.service;

import com.fiap.agrobot.dto.EstufaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstufaService {

    public List<EstufaDTO> listarEstufasAtivas() {
        // Dados Mock
        return List.of(
                new EstufaDTO(1L, "Estufa Gigante", "Alface Crespo", 22.5, 65.0, "OPERACIONAL"),
                new EstufaDTO(2L, "Estufa Sem Aura", "Tomate Cereja", 24.0, 40.0, "ALERTA")
        );
    }
}
