package com.surpreenda.projetosocial.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Campanha implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "STATUS")
    private String status ;

    @Column(name = "DESCRICAO")
    private String descricao;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "DATAINICIO")
    private Date dataInicio;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "DATAFINAL")
    private Date dataFinal;

    @JsonIgnore
    @OneToMany(mappedBy = "campanha")
    private List<Doacao> doacaoList = new ArrayList<>();

    public Campanha(){
    }

    public Campanha(String titulo, String status, String descricao, Date dataInicio,
                    Date dataFinal) {
        this.titulo = titulo;
        this.status = status;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public List<Doacao> getDoacaoList() {
        return doacaoList;
    }

    public void setDoacaoList(List<Doacao> doacaoList) {
        this.doacaoList = doacaoList;
    }
}
