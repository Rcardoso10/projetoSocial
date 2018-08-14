package com.surpreenda.projetosocial.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Doacao implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "QUANTIDADE")
    private Long quantidade;

    @Column(name = "UNIDADEMEDIDA")
    private String unidadeMedida;

    @Column(name = "DESCRICAO")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "CAMPANHA_ID")
    private Campanha campanha;

    @OneToOne
    @JoinColumn(name = "PESSOA_ID")
    private Pessoa pessoa;

    public Doacao(){
    }

    public Doacao(Long quantidade, String unidadeMedida, String descricao) {
        this.quantidade = quantidade;
        this.unidadeMedida = unidadeMedida;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Campanha getCampanha() {
        return campanha;
    }

    public void setCampanha(Campanha campanha) {
        this.campanha = campanha;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
