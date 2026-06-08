package com.fiap.agrobot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.agrobot.dto.HabitatDTO;
import com.fiap.agrobot.model.Habitat;
import com.fiap.agrobot.service.HabitatService;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HabitatController.class)
class HabitatControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private HabitatService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveListarHabitats() throws Exception {

        List<HabitatDTO> lista = List.of();

        when(service.listarEstufasAtivas())
                .thenReturn(lista);

        mockMvc.perform(get("/api/habitat"))
                .andExpect(status().isOk());
    }

    @Test
    void deveAtualizarHabitat() throws Exception {

        Habitat habitat = new Habitat();

        HabitatDTO dto = new HabitatDTO(
                1L,
                "Habitat Teste",
                "folha",
                12.5,
                10.1,
                "viva"
        );

        when(service.atualizar(eq(1L), any(Habitat.class)))
                .thenReturn(dto);

        mockMvc.perform(
                        put("/api/habitat/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(habitat))
                )
                .andExpect(status().isOk());
    }

    @Test
    void deveExcluirHabitat() throws Exception {

        doNothing().when(service).excluir(1L);

        mockMvc.perform(delete("/api/habitat/1"))
                .andExpect(status().isNoContent());
    }
}