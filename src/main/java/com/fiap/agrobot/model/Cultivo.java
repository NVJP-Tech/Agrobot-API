package com.fiap.agrobot.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "TBL_CULTIVO")
public class Cultivo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CULTIVO")
    @SequenceGenerator(name = "SEQ_CULTIVO", sequenceName = "SEQ_CULTIVO", allocationSize = 1)
    @Column(name = "cul_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cul_plt_id")
    private Planta planta;

    @ManyToOne
    @JoinColumn(name = "cul_hab_id")
    private Habitat habitat;

    @ManyToOne
    @JoinColumn(name = "cul_ast_id")
    private Astronauta astronauta;

    @Column(name = "cul_dt_inicio")
    private LocalDate dataInicio = LocalDate.now();

    @Column(name = "cul_dt_colheita_prev")
    private LocalDate dataPrevisaoColheita;

    @Column(name = "cul_status")
    private Integer status = 1; // 1 para Ativo

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    public Astronauta getAstronauta() {
        return astronauta;
    }

    public void setAstronauta(Astronauta astronauta) {
        this.astronauta = astronauta;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataPrevisaoColheita() {
        return dataPrevisaoColheita;
    }

    public void setDataPrevisaoColheita(LocalDate dataPrevisaoColheita) {
        this.dataPrevisaoColheita = dataPrevisaoColheita;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
