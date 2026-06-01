package com.fiap.agrobot.service;

import com.fiap.agrobot.model.Habitat;
import com.fiap.agrobot.model.Log;
import com.fiap.agrobot.repository.HabitatRepository;
import com.fiap.agrobot.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    @Autowired private LogRepository repository;
    @Autowired private HabitatRepository habitatRepo;

    public Log registrarLeitura(Long habId, String tipoSensor, Double valor) {
        Habitat hab = habitatRepo.findById(habId).get();

        Log log = new Log();
        log.setHabitat(hab);
        log.setSensor(tipoSensor);
        log.setValorLido(valor);
        log.setCategoria("VIDA");

        // LÓGICA DE ALERTA: Se a temperatura for maior que 30 graus em Marte...
        if (tipoSensor.equals("TEMPERATURA") && valor > 30.0) {
            log.setSeveridade("CRITICO");
            log.setDescricao("ALERTA: Calor excessivo detectado! Ativando resfriamento.");
        } else {
            log.setSeveridade("NORMAL");
            log.setDescricao("Leitura nominal realizada com sucesso.");
        }

        return repository.save(log);
    }

    public List<Log> listarAlertas() {
        return repository.findAll();
    }
}
