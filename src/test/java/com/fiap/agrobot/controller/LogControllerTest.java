package com.fiap.agrobot.controller;

import com.fiap.agrobot.dto.LogDTO;
import com.fiap.agrobot.service.LogService;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LogController.class)
class LogControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private LogService service;

    @Test
    void deveListarLogs() throws Exception {

        List<LogDTO> lista = List.of();

        when(service.listarAlertas())
                .thenReturn(lista);

        mockMvc.perform(get("/api/logs"))
                .andExpect(status().isOk());
    }

    @Test
    void deveReceberDadosSensor() throws Exception {

        LogDTO dto = new LogDTO(
                1L,
                "planta teste",
                "habitat test",
                "temperatura",
                12.5,
                "fraco",
                "temperatura ideal para o teste",
                "20-08-2026"
        );

        when(service.registrarLeitura(
                eq(1L),
                eq("TEMPERATURA"),
                eq(22.5)
        )).thenReturn(dto);

        mockMvc.perform(
                        post("/api/logs/sensor/1")
                                .param("tipo", "TEMPERATURA")
                                .param("valor", "22.5")
                )
                .andExpect(status().isCreated());
    }
}