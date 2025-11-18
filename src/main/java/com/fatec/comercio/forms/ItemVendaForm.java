package com.fatec.comercio.forms;

import java.math.BigDecimal;

public class ItemVendaForm {
    private Integer produtoId;
    private BigDecimal quantidade;

    public Integer getProdutoId() {
        return produtoId;
    }
    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }
    public BigDecimal getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }
}
