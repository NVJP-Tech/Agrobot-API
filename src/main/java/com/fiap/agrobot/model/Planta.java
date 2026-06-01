package com.fiap.agrobot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_PLANTA")
public class Planta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PLANTA")
    @SequenceGenerator(name = "SEQ_PLANTA", sequenceName = "SEQ_PLANTA", allocationSize = 1)
    @Column(name = "plt_id")
    private Long id;

    @Column(name = "plt_nome", nullable = false, unique = true)
    private String nome;

    @Column(name = "plt_descricao")
    private String descricao;

    @Column(name = "plt_temp_ideal_min")
    private Double tempMin;

    @Column(name = "plt_temp_ideal_max")
    private Double tempMax;

    @Column(name = "plt_ph_min")
    private Double phMin;

    @Column(name = "plt_ph_max")
    private Double phMax;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    public Double getPhMin() {
        return phMin;
    }

    public void setPhMin(Double phMin) {
        this.phMin = phMin;
    }

    public Double getPhMax() {
        return phMax;
    }

    public void setPhMax(Double phMax) {
        this.phMax = phMax;
    }
}
