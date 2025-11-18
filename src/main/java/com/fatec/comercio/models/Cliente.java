package com.fatec.comercio.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codcliente;
    @Column
    private String nomecliente;
    @Column
    private String cpfcliente;
    @Column
    private String datanasc;
    @Column
    private String numerocasa;

    @ManyToOne
    @JoinColumn(name = "codsexofk")
    private Sexo sexo;

    @ManyToOne
    @JoinColumn(name = "codruafk")
    private Rua rua;

    @ManyToOne
    @JoinColumn(name = "codcidadefk")
    private Cidade cidade;

    @ManyToOne
    @JoinColumn(name = "codbairrofk")
    private Bairro bairro;

    @ManyToOne
    @JoinColumn(name = "codcepfk")
    private Cep cep;


    public Integer getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(Integer codcliente) {
        this.codcliente = codcliente;
    }

    public String getNomecliente() {
        return nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }

    public String getCpfcliente() {
        return cpfcliente;
    }

    public void setCpfcliente(String cpfcliente) {
        this.cpfcliente = cpfcliente;
    }

    public String getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(String datanasc) {
        this.datanasc = datanasc;
    }

    public String getNumerocasa() {
        return numerocasa;
    }

    public void setNumerocasa(String numerocasa) {
        this.numerocasa = numerocasa;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Rua getRua() {
        return rua;
    }

    public void setRua(Rua rua) {
        this.rua = rua;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public Cep getCep() {
        return cep;
    }

    public void setCep(Cep cep) {
        this.cep = cep;
    }

    public Cliente(String nomecliente, String cpfcliente, String datanasc, String numerocasa, Sexo sexo, Rua rua, Cidade cidade, Bairro bairro, Cep cep){
        this.nomecliente = nomecliente;
        this.cpfcliente = cpfcliente;
        this.datanasc = datanasc;
        this.numerocasa = numerocasa;
        this.sexo = sexo;
        this.rua = rua;
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
    }

    public Cliente(){

    }
}