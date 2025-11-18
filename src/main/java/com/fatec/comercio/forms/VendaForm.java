package com.fatec.comercio.forms;

import java.util.List;

public class VendaForm {
    private Integer clienteId;
    private List<ItemVendaForm> itens;

    public Integer getClienteId() {
        return clienteId;
    }
    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }
    public List<ItemVendaForm> getItens() {
        return itens;
    }
    public void setItens(List<ItemVendaForm> itens) {
        this.itens = itens;
    }
}
