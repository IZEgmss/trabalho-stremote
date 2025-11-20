package com.fatec.comercio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fatec.comercio.models.Estado;
import com.fatec.comercio.repository.EstadoRepository;

@Service
public class EstadoService {
    @Autowired 
    private EstadoRepository estadoRepository;

    public EstadoService(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    //Buscar todos os Estados
    public List<Estado> allUfs(){
        return estadoRepository.findAll();
    }

    //Buscar Estado pelo Código
    public Estado ufId(Integer id){
        return estadoRepository.findByCoduf(id);
    }

    //Apagar Estado pelo Código
    public void apagaId(Integer id){
        estadoRepository.deleteById(id);
    }

    //Salvar Estado
    public String salvarUf(Estado uf){
        estadoRepository.save(uf);
        return "Estado Cadastrado com sucesso!";
    }

     //Editar Estado
    public void editarUf(Integer id, Estado uf){
        uf.setCoduf(id);
        estadoRepository.save(uf);
    }
}
