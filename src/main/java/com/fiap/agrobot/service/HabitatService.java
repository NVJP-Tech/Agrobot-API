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

    public HabitatDTO atualizar(Long id, Habitat habitatAtualizado) {
        Habitat existente = habitatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Habitat não encontrado"));

        // Atualiza os campos vindos do corpo da requisição
        existente.setNome(habitatAtualizado.getNome());
        existente.setStatus(habitatAtualizado.getStatus());
        existente.setTemperatura(habitatAtualizado.getTemperatura());
        existente.setUmidade(habitatAtualizado.getUmidade());
        existente.setPressao(habitatAtualizado.getPressao());
        existente.setCo2(habitatAtualizado.getCo2());

        Habitat salvo = habitatRepository.save(existente);

        // Retorna o DTO atualizado
        return new HabitatDTO(
                salvo.getId(),
                salvo.getNome(),
                "Monitoramento Ativo",
                salvo.getTemperatura(),
                salvo.getUmidade(),
                salvo.getStatus() == 1 ? "OPERACIONAL" : "ALERTA"
        );
    }

    public void excluir(Long id) {
        habitatRepository.deleteById(id);
    }
}
