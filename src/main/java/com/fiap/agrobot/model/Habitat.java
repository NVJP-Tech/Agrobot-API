package com.fiap.agrobot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_HABITAT")
public class Habitat {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_HABITAT")
    @SequenceGenerator(name = "SEQ_HABITAT", sequenceName = "SEQ_HABITAT", allocationSize = 1)
    @Column(name = "hab_id")
    private Long id;

    @Column(name = "hab_nome")
    private String nome;

    @Column(name = "hab_temp_atual")
    private Double temperatura;

    @Column(name = "hab_umidade_atual")
    private Double umidade;

    @Column(name = "hab_pressao_atual")
    private Double pressao;

    @Column(name = "hab_co2_atual")
    private Double co2;

    @Column(name = "hab_status")
    private Integer status;

    // Adicione os outros campos se quiser: hab_pressao_atual, hab_co2_atual, etc.

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

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getUmidade() {
        return umidade;
    }

    public void setUmidade(Double umidade) {
        this.umidade = umidade;
    }

    public Double getPressao() {
        return pressao;
    }

    public void setPressao(Double pressao) {
        this.pressao = pressao;
    }

    public Double getCo2() {
        return co2;
    }

    public void setCo2(Double co2) {
        this.co2 = co2;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
