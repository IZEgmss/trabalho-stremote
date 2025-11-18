package com.fatec.comercio.repository;

import com.fatec.comercio.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository <Cliente, Integer> {
    public Cliente findByCodcliente(Integer id);
    public Cliente findByNomecliente(String nomecliente);
}
