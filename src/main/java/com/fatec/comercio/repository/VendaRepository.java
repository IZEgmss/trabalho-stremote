package com.fatec.comercio.repository;

import com.fatec.comercio.models.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Date;

public interface VendaRepository extends JpaRepository<Venda, Integer> {

}
