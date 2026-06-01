package com.fiap.agrobot.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_LOG")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LOG")
    @SequenceGenerator(name = "SEQ_LOG", sequenceName = "SEQ_LOG", allocationSize = 1)
    @Column(name = "log_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "log_hab_id")
    private Habitat habitat;

    @Column(name = "log_sensor")
    private String sensor; // Ex: "TEMPERATURA"

    @Column(name = "log_valor_lido")
    private Double valorLido;

    @Column(name = "log_categoria")
    private String categoria; // "VIDA"

    @Column(name = "log_severidade")
    private String severidade; // "ATENCAO" ou "CRITICO"

    @Column(name = "log_descricao")
    private String descricao;

    @Column(name = "log_dt_alerta")
    private LocalDateTime dataAlerta = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    public Double getValorLido() {
        return valorLido;
    }

    public void setValorLido(Double valorLido) {
        this.valorLido = valorLido;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSeveridade() {
        return severidade;
    }

    public void setSeveridade(String severidade) {
        this.severidade = severidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataAlerta() {
        return dataAlerta;
    }

    public void setDataAlerta(LocalDateTime dataAlerta) {
        this.dataAlerta = dataAlerta;
    }
}
