package com.fatec.comercio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.comercio.models.Cep;
import com.fatec.comercio.repository.CepRepository;

@Service
public class CepService {

    @Autowired
    private CepRepository cepRepository;

    public CepService(CepRepository cepRepository) {
        this.cepRepository = cepRepository;
    }

    public List<Cep> allCeps() {
        return cepRepository.findAll();
    }

    public Cep cepId(Integer id) {
        return cepRepository.findByCodcep(id);
    }

    public void apagaId(Integer id) {
        cepRepository.deleteById(id);
    }

    public Cep salvarCep(Cep cep) {
        return cepRepository.save(cep);
    }

    public void editarCep(Integer id, Cep cep) {
        cep.setCodcep(id);
        cepRepository.save(cep);
    }
}
