package com.fiap.agrobot.dto;

public record LogDTO(
        Long id,
        String planta,
        String habitat,
        String sensor,
        Double valor,
        String severidade,
        String descricao,
        String dataAlerta
) {}
