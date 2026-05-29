package com.fiap.agrobot.dto;

public record HabitatDTO(
        Long id,
        String nome,
        String planta,
        double temp,
        double umid,
        String status
) {
}
