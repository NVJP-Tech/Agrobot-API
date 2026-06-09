package com.fiap.agrobot.controller;

import com.fiap.agrobot.dto.PlantaDTO;
import com.fiap.agrobot.service.PlantaService;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PlantaController.class)
class PlantaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PlantaService service;

    @Test
    void deveListarCatalogo() throws Exception {

        List<PlantaDTO> lista = List.of();

        when(service.listarCatalogo())
                .thenReturn(lista);

        mockMvc.perform(get("/api/plantas"))
                .andExpect(status().isOk());
    }
}