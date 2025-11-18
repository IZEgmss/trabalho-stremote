package com.fatec.comercio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.comercio.models.Sexo;
import com.fatec.comercio.repository.SexoRepository;

@Service
public class SexoService {

    //injeção de dependência
    @Autowired
    private SexoRepository sexoRepository;

    //Criando o construtor da Classe SexoService
    public SexoService(SexoRepository sexoRepository) {

        this.sexoRepository = sexoRepository;
    }

    //Buscar todos os Sexos
    public List<Sexo> allSexos(){

        return sexoRepository.findAll();
    }

    //Buscar pelo Código
    public Sexo sexoId(Integer id){

        return sexoRepository.findByCodsexo(id);
    }
    
    //Apagar sexo pelo Código
    public void apagaId(Integer id){

        sexoRepository.deleteById(id);
    }
    
    //Salvar Sexo
    public Sexo salvarSexo(Sexo sexo){

        return sexoRepository.save(sexo);
    }

    //Editar Sexo
    public void editarSexo(Integer id, Sexo sexo){
        sexo.setCodsexo(id);
        sexoRepository.save(sexo);
    }
    
}
