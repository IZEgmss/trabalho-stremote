package com.fatec.comercio.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.comercio.models.Estado;
import com.fatec.comercio.service.EstadoService;

@RestController
@RequestMapping("/ufs")
public class EstadoController {

    private final EstadoService ufService;

    public EstadoController(EstadoService ufService) {
        this.ufService = ufService;
    }

    @GetMapping("")
    public List<Estado> getUfs() {
        return ufService.allUfs();
    }

    @GetMapping("/{id}")
    public Estado getUfId(@PathVariable Integer id) {
        return ufService.ufId(id);
    }

    @PostMapping("")
    public String postUf(@RequestBody Estado uf) {
        ufService.salvarUf(uf);
        return "Dados Salvos com Sucesso!!!";
    }

    @DeleteMapping("/{id}")
    public String deletaId(@PathVariable Integer id) {
        ufService.apagaId(id);
        return "O Estado de código: " + id + " foi deletado";
    }

    @PutMapping("/{id}")
    public String putUf(@PathVariable Integer id, @RequestBody Estado uf) {
        // TODO: process PUT request
        ufService.editarUf(id, uf);
        return "Dados atualizados com sucesso!";
    }
}
