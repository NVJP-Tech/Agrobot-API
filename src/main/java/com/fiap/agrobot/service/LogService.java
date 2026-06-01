package com.fiap.agrobot.service;

import com.fiap.agrobot.dto.LogDTO;
import com.fiap.agrobot.model.Cultivo;
import com.fiap.agrobot.model.Habitat;
import com.fiap.agrobot.model.Log;
import com.fiap.agrobot.repository.CultivoRepository;
import com.fiap.agrobot.repository.HabitatRepository;
import com.fiap.agrobot.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    @Autowired private LogRepository repository;
    @Autowired private CultivoRepository cultivoRepo;

    public LogDTO registrarLeitura(Long culId, String tipoSensor, Double valor) {
        Cultivo cultivo = cultivoRepo.findById(culId)
                .orElseThrow(() -> new RuntimeException("Cultivo não encontrado"));

        Log log = new Log();
        log.setCultivo(cultivo);
        log.setPlanta(cultivo.getPlanta()); // Definindo a planta manualmente para o DTO ficar completo
        log.setHabitat(cultivo.getHabitat());
        log.setSensor(tipoSensor);
        log.setValorLido(valor);
        log.setCategoria("VIDA");

        if (tipoSensor.equals("TEMPERATURA") && valor > 30.0) {
            log.setSeveridade("CRITICO");
            log.setDescricao("ALERTA: Calor excessivo no cultivo de " + cultivo.getPlanta().getNome() + "!");
        } else {
            log.setSeveridade("NORMAL");
            log.setDescricao("Monitoramento nominal para " + cultivo.getPlanta().getNome());
        }

        Log salvo = repository.save(log);

        // Retorna o DTO do log que acabou de ser salvo
        return new LogDTO(
                salvo.getId(),
                salvo.getCultivo().getPlanta().getNome(),
                salvo.getHabitat().getNome(),
                salvo.getSensor(),
                salvo.getValorLido(),
                salvo.getSeveridade(),
                salvo.getDescricao(),
                salvo.getDataAlerta().toString()
        );
    }

    public List<LogDTO> listarAlertas() {
        return repository.findAll().stream().map(log -> new LogDTO(
                log.getId(),
                log.getCultivo() != null ? log.getCultivo().getPlanta().getNome() : "N/A",
                log.getHabitat().getNome(),
                log.getSensor(),
                log.getValorLido(),
                log.getSeveridade(),
                log.getDescricao(),
                log.getDataAlerta().toString()
        )).toList();
    }
}
