package com.fatec.comercio.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class VendaProduto {

    @EmbeddedId
    private VendaProdutoId id;

    @ManyToOne
    @MapsId("codvendafk")
    @JoinColumn(name = "codvendafk")
    @JsonIgnore
    private Venda venda;

    @ManyToOne
    @MapsId("codprodutofk")
    @JoinColumn(name = "codprodutofk")
    private Produto produto;

    @Column(name = "quantv", precision = 10, scale = 2)
    private BigDecimal quantidadeVendida;

    @Column(name = "valorv", precision = 10, scale = 2)
    private BigDecimal valorVenda;

    public VendaProdutoId getId() {
        return id;
    }

    public void setId(VendaProdutoId id) {
        this.id = id;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(BigDecimal quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }
}
