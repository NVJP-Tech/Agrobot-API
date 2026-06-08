package com.fiap.agrobot.controller;

import com.fiap.agrobot.dto.CultivoDTO;
import com.fiap.agrobot.model.Cultivo;
import com.fiap.agrobot.service.CultivoService;
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

@WebMvcTest(CultivoController.class)
class CultivoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CultivoService service;

    @Test
    void deveListarCultivosAtivos() throws Exception {

        List<CultivoDTO> lista = List.of();

        when(service.listarAtivos()).thenReturn(lista);

        mockMvc.perform(get("/api/cultivos"))
                .andExpect(status().isOk());
    }

    @Test
    void deveIniciarCultivo() throws Exception {

        Cultivo cultivo = new Cultivo();

        when(service.salvar(
                eq(1L),
                eq(2L),
                eq(3L)
        )).thenReturn(cultivo);

        mockMvc.perform(post("/api/cultivos/1/2/3"))
                .andExpect(status().isCreated());
    }
}
