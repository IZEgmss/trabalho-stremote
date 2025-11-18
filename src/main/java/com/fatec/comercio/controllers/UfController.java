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

import com.fatec.comercio.models.Uf;
import com.fatec.comercio.service.UfService;

@RestController
@RequestMapping("/ufs")
public class UfController {

    private final UfService ufService;

    public UfController(UfService ufService) {
        this.ufService = ufService;
    }

    @GetMapping("")
    public List<Uf> getUfs() {
        return ufService.allUfs();
    }

    @GetMapping("/{id}")
    public Uf getUfId(@PathVariable Integer id) {
        return ufService.ufId(id);
    }

    @PostMapping("")
    public String postUf(@RequestBody Uf uf) {
        ufService.salvarUf(uf);
        return "Dados Salvos com Sucesso!!!";
    }

    @DeleteMapping("/{id}")
    public String deletaId(@PathVariable Integer id) {
        ufService.apagaId(id);
        return "O Uf de código: " + id + " foi deletado";
    }

    @PutMapping("/{id}")
    public String putUf(@PathVariable Integer id, @RequestBody Uf uf) {
        // TODO: process PUT request
        ufService.editarUf(id, uf);
        return "Dados atualizados com sucesso!";
    }
}
