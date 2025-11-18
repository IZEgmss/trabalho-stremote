package com.fatec.comercio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.comercio.models.Cidade;
import java.util.List;


public interface CidadeRepository extends JpaRepository <Cidade, Integer> {
    public Cidade findByCodcidade(Integer id);
    public Cidade findByNomecidade(String nomecidade);
}
