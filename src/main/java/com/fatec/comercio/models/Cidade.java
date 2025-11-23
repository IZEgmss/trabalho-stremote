package com.fatec.comercio.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codcidade;
    @Column
    private String nomecidade;

    @ManyToOne
    @JoinColumn(name = "coduffk")
    private Estado uf;



    public Integer getCodcidade() {
        return codcidade;
    }

    public void setCodcidade(Integer codcidade) {
        this.codcidade = codcidade;
    }

    public String getNomecidade() {
        return nomecidade;
    }

    public void setNomecidade(String nomecidade) {
        this.nomecidade = nomecidade;
    }

    public Estado getUf() {
        return uf;
    }

    public void setUf(Estado uf) {
        this.uf = uf;
    }

    public Cidade(String nomecidade, Estado uf){
        this.nomecidade = nomecidade;
        this.uf = uf;
    }

    public Cidade(){
        
    }
}
