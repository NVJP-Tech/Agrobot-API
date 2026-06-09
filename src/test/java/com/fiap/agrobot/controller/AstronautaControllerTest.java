package com.fiap.agrobot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.agrobot.controller.AstronautaController;
import com.fiap.agrobot.dto.AstronautaDTO;
import com.fiap.agrobot.model.Astronauta;
import com.fiap.agrobot.service.AstronautaService;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AstronautaController.class)
class AstronautaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private AstronautaService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveListarAstronautas() throws Exception {

        List<AstronautaDTO> lista = List.of(
                new AstronautaDTO(1L, "Teste", "Testar dto", 1)
        );

        when(service.listarTodos()).thenReturn(lista);

        mockMvc.perform(get("/api/astronautas"))
                .andExpect(status().isOk());
    }

    @Test
    void deveCadastrarAstronauta() throws Exception {

        Astronauta astronauta = new Astronauta();

        AstronautaDTO dto = new AstronautaDTO(2L, "Teste2", "Testar dto2", 1);

        when(service.salvar(any(Astronauta.class)))
                .thenReturn(dto);

        mockMvc.perform(post("/api/astronautas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(astronauta)))
                .andExpect(status().isCreated());
    }

    @Test
    void deveAtualizarAstronauta() throws Exception {

        Long id = 1L;

        Astronauta astronauta = new Astronauta();

        AstronautaDTO dto = new AstronautaDTO(3L, "Teste3", "Testar dto3", 1);

        when(service.atualizar(eq(id), any(Astronauta.class)))
                .thenReturn(dto);

        mockMvc.perform(put("/api/astronautas/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(astronauta)))
                .andExpect(status().isOk());
    }

    @Test
    void deveExcluirAstronauta() throws Exception {

        doNothing().when(service).excluir(1L);

        mockMvc.perform(delete("/api/astronautas/1"))
                .andExpect(status().isNoContent());
    }
}
