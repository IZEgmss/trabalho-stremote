package com.fatec.comercio.models;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class VendaProdutoId implements Serializable {

    private Integer codvendafk;
    private Integer codprodutofk;

    public VendaProdutoId() {
    }

    public VendaProdutoId(Integer codvendafk, Integer codprodutofk) {
        this.codvendafk = codvendafk;
        this.codprodutofk = codprodutofk;
    }

    public Integer getCodvendafk() {
        return codvendafk;
    }

    public void setCodvendafk(Integer codvendafk) {
        this.codvendafk = codvendafk;
    }

    public Integer getCodprodutofk() {
        return codprodutofk;
    }

    public void setCodprodutofk(Integer codprodutofk) {
        this.codprodutofk = codprodutofk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendaProdutoId that = (VendaProdutoId) o;
        return Objects.equals(codvendafk, that.codvendafk) &&
                Objects.equals(codprodutofk, that.codprodutofk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codvendafk, codprodutofk);
    }
}
