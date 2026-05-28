package com.fiap.agrobot.dto;

public record EstufaDTO(
        Long id,
        String nome,
        String planta,
        double temp,
        double umid,
        String status
) {
}
