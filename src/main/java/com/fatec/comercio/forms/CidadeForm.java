package com.fatec.comercio.forms;

import com.fatec.comercio.models.Cidade;
import com.fatec.comercio.models.Uf;
import com.fatec.comercio.repository.UfRepository;

public class CidadeForm {
    private Integer codcidade;
    private String nomecidade;
    private String nomeuf;


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
    public String getNomeuf() {
        return nomeuf;
    }
    public void setNomeuf(String nomeuf) {
        this.nomeuf = nomeuf;
    }

    //metodo conversao p entidade cidade
    public Cidade converter(UfRepository ufRepository){
        Uf uf = ufRepository.findByNomeuf(nomeuf);
        return new Cidade(nomecidade, uf);
    }

}
