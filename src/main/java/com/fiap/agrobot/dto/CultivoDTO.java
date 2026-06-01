package com.fiap.agrobot.dto;

public record CultivoDTO(
        Long id,
        String nomePlanta,
        String nomeHabitat,
        String responsavel,
        String previsaoColheita
) {}
