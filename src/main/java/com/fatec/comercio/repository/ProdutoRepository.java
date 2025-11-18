package com.fatec.comercio.repository;

import com.fatec.comercio.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository <Produto, Integer> {
    public Produto findByCodproduto(Integer id);
    public Produto findByNomeproduto(String nomeproduto);
}