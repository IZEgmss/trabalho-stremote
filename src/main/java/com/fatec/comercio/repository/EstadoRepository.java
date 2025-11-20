package com.fatec.comercio.repository;

import com.fatec.comercio.models.Cidade;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.comercio.models.Estado;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;


public interface EstadoRepository extends JpaRepository<Estado, Integer>{
    Estado findByNomeuf(String nomeuf);
    Estado findBySigla(String sigla);
    Estado findByCoduf(Integer coduf);
}