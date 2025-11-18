package com.fatec.comercio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.comercio.models.Rua;

public interface RuaRepository extends JpaRepository<Rua, Integer>{
    Rua findByNomerua(String nomerua);
    Rua findByCodrua(Integer codrua);
}
