package com.fatec.comercio.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codvenda;

    @Temporal(TemporalType.DATE)
    private Date datavenda;

    @ManyToOne
    @JoinColumn(name = "codclientefk")
    private Cliente cliente;

    // Uma Venda tem uma lista de VendaProduto (os itens da venda)
    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VendaProduto> itens;

    // Getters e Setters

    public Integer getCodvenda() {
        return codvenda;
    }

    public void setCodvenda(Integer codvenda) {
        this.codvenda = codvenda;
    }

    public Date getDatavenda() {
        return datavenda;
    }

    public void setDatavenda(Date datavenda) {
        this.datavenda = datavenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<VendaProduto> getItens() {
        return itens;
    }

    public void setItens(List<VendaProduto> itens) {
        this.itens = itens;
    }
}
