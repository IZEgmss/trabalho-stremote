package com.fatec.comercio.repository;

import com.fatec.comercio.models.Cidade;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.comercio.models.Uf;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;


public interface UfRepository extends JpaRepository<Uf, Integer>{
    Uf findByNomeuf(String nomeuf);
    Uf findBySigla(String sigla);
    Uf findByCoduf(Integer coduf);
}