package com.fiap.agrobot.service;

import com.fiap.agrobot.dto.HabitatDTO;
import com.fiap.agrobot.model.Habitat;
import com.fiap.agrobot.repository.HabitatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitatService {

    @Autowired
    private HabitatRepository habitatRepository;

    public List<HabitatDTO> listarEstufasAtivas() {
        // Busca do Oracle
        List<Habitat> habitats = habitatRepository.findAll();

        // Converte cada "Entity" do banco para um "DTO" para o Front-end
        return habitats.stream().map(h -> new HabitatDTO(
                h.getId(),
                h.getNome(),
                "Cultura Ativa",
                h.getTemperatura(),
                h.getUmidade(),
                h.getStatus() == 1 ? "OPERACIONAL" : "ALERTA"
        )).toList();
    }
}
