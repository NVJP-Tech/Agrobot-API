package com.fiap.agrobot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_ASTRONAUTA")
public class Astronauta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ASTRONAUTA")
    @SequenceGenerator(name = "SEQ_ASTRONAUTA", sequenceName = "SEQ_ASTRONAUTA", allocationSize = 1)
    @Column(name = "ast_id")
    private Long id;

    @Column(name = "ast_nome", nullable = false)
    private String nome;

    @Column(name = "ast_funcao", nullable = false)
    private String funcao; // Ex: Comandante, Engenheiro, Biólogo

    @Column(name = "ast_senha_hash", nullable = false)
    private String senha;

    @Column(name = "ast_status")
    private Integer status = 1; // 1 para Ativo, 0 para Inativo

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

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
