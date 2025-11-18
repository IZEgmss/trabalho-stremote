package com.fatec.comercio.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Cep {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer codcep;

    @Column
    private String numerocep;

    public Integer getCodcep() {
        return codcep;
    }

    public void setCodcep(Integer codcep) {
        this.codcep = codcep;
    }

    public String getNumerocep() {
        return numerocep;
    }

    public void setNumerocep(String numerocep) {
        this.numerocep = numerocep;
    }

}
