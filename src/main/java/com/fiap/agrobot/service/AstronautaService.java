package com.fiap.agrobot.service;

import com.fiap.agrobot.dto.AstronautaDTO;
import com.fiap.agrobot.model.Astronauta;
import com.fiap.agrobot.repository.AstronautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AstronautaService {

    @Autowired
    private AstronautaRepository repository;

    public List<AstronautaDTO> listarTodos() {
        return repository.findAll().stream()
                .map(a -> new AstronautaDTO(a.getId(), a.getNome(), a.getFuncao(), a.getStatus()))
                .toList();
    }

    public AstronautaDTO salvar(Astronauta astronauta) {
        Astronauta salvo = repository.save(astronauta);
        return new AstronautaDTO(salvo.getId(), salvo.getNome(), salvo.getFuncao(), salvo.getStatus());
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public AstronautaDTO atualizar(Long id, Astronauta astronauta) {
        Astronauta existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Astronauta não encontrado"));

        existente.setNome(astronauta.getNome());
        existente.setFuncao(astronauta.getFuncao());
        existente.setStatus(astronauta.getStatus());

        Astronauta atualizado = repository.save(existente);
        return new AstronautaDTO(atualizado.getId(), atualizado.getNome(), atualizado.getFuncao(), atualizado.getStatus());
    }
}
