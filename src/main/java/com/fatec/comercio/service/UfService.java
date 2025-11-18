package com.fatec.comercio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fatec.comercio.models.Uf;
import com.fatec.comercio.repository.UfRepository;

@Service
public class UfService {
    @Autowired 
    private UfRepository ufRepository;

    public UfService(UfRepository ufRepository) {
        this.ufRepository = ufRepository;
    }

    //Buscar todos os Ufs
    public List<Uf> allUfs(){
        return ufRepository.findAll();
    }

    //Buscar Uf pelo Código
    public Uf ufId(Integer id){
        return ufRepository.findByCoduf(id);
    }

    //Apagar Uf pelo Código
    public void apagaId(Integer id){
        ufRepository.deleteById(id);
    }

    //Salvar Uf
    public String salvarUf(Uf uf){
        ufRepository.save(uf);
        return "Uf Cadastrado com sucesso!";
    }

     //Editar Uf
    public void editarUf(Integer id, Uf uf){
        uf.setCoduf(id);
        ufRepository.save(uf);
    }
}
