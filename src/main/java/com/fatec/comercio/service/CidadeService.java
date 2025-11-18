package com.fatec.comercio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.comercio.forms.CidadeForm;
import com.fatec.comercio.models.Cidade;
import com.fatec.comercio.models.Uf;
import com.fatec.comercio.repository.CidadeRepository;
import com.fatec.comercio.repository.UfRepository;
import org.springframework.transaction.annotation.Transactional;

@Service    
public class CidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private UfRepository ufRepository;

    public CidadeService(CidadeRepository cidadeRepository){
        this.cidadeRepository = cidadeRepository;
    }

    public List <Cidade> allCidades(){
        return cidadeRepository.findAll();
    }

    public Cidade cidadeId(Integer id){
        return cidadeRepository.findByCodcidade(id);
    }

    public Cidade cidadeNomecidade(String nomecidade){
        return cidadeRepository.findByNomecidade(nomecidade);
    }

    public void apagaCidadeId(Integer id){
        cidadeRepository.deleteById(id);
    }

    public Cidade salvarCidade(CidadeForm cidadeForm){
        Cidade cidade = cidadeForm.converter(ufRepository);
        return cidadeRepository.save(cidade);
    }

    @Transactional
    public Cidade editaCidade(CidadeForm cidadeForm, Integer id){
        Uf uf = ufRepository.findByNomeuf(cidadeForm.getNomeuf());
        Cidade cidade = cidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cidade não encontrada com o ID:"+id));
        cidade.setNomecidade(cidadeForm.getNomecidade());
        cidade.setUf(uf);
        return cidadeRepository.save(cidade);

    }
}
