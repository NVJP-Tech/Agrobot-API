package com.fiap.agrobot.dto;

public record PlantaDTO(
        Long id,
        String nome,
        String descricao,
        String faixaTemp, // Ex: "18°C - 24°C"
        String faixaPh    // Ex: "6.0 - 7.5"
) {}
