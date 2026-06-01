package com.fiap.agrobot.service;

import com.fiap.agrobot.dto.CultivoDTO;
import com.fiap.agrobot.model.Cultivo;
import com.fiap.agrobot.repository.AstronautaRepository;
import com.fiap.agrobot.repository.CultivoRepository;
import com.fiap.agrobot.repository.HabitatRepository;
import com.fiap.agrobot.repository.PlantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CultivoService {

    @Autowired private CultivoRepository repository;
    @Autowired private PlantaRepository plantaRepo;
    @Autowired private HabitatRepository habitatRepo;
    @Autowired private AstronautaRepository astronautaRepo;

    public List<CultivoDTO> listarAtivos() {
        return repository.findAll().stream().map(c -> new CultivoDTO(
                c.getId(),
                c.getPlanta().getNome(),
                c.getHabitat().getNome(),
                c.getAstronauta().getNome(),
                c.getDataPrevisaoColheita().toString()
        )).toList();
    }

    public Cultivo salvar(Long plantaId, Long habitatId, Long astronautaId) {
        Cultivo novo = new Cultivo();
        novo.setPlanta(plantaRepo.findById(plantaId).get());
        novo.setHabitat(habitatRepo.findById(habitatId).get());
        novo.setAstronauta(astronautaRepo.findById(astronautaId).get());

        // Simulando uma previsão de 30 dias para o MVP
        novo.setDataPrevisaoColheita(LocalDate.now().plusDays(30));

        return repository.save(novo);
    }
}
