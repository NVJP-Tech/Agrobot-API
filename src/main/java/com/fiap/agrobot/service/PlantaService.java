package com.fiap.agrobot.service;

import com.fiap.agrobot.dto.PlantaDTO;
import com.fiap.agrobot.repository.PlantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantaService {

    @Autowired
    private PlantaRepository plantaRepository;

    public List<PlantaDTO> listarCatalogo() {
        return plantaRepository.findAll().stream().map(p -> new PlantaDTO(
                p.getId(),
                p.getNome(),
                p.getDescricao(),
                p.getTempMin() + "°C - " + p.getTempMax() + "°C",
                p.getPhMin() + " - " + p.getPhMax()
        )).toList();
    }
}
