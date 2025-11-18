package com.fatec.comercio.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codproduto;
    @Column
    private String nomeproduto;
    @Column
    private BigDecimal valor;
    @Column
    private BigDecimal quantidade;


    @ManyToOne
    @JoinColumn(name = "codmarcafk")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "codtipofk")
    private Tipo tipo;

    public Integer getCodproduto() {
        return codproduto;
    }

    public void setCodproduto(Integer codproduto) {
        this.codproduto = codproduto;
    }

    public String getNomeproduto() {
        return nomeproduto;
    }

    public void setNomeproduto(String nomeproduto) {
        this.nomeproduto = nomeproduto;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Produto(String nomeproduto, BigDecimal valor, BigDecimal quantidade, Marca marca, Tipo tipo){
        this.nomeproduto = nomeproduto;
        this.valor = valor;
        this.quantidade = quantidade;
        this.marca = marca;
        this.tipo = tipo;
    }

    public Produto(){

    }
}