package com.fatec.comercio.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.comercio.models.Bairro;
import com.fatec.comercio.service.BairroService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/bairros")

public class BairroController {
     private final BairroService bairroService;

    public BairroController(BairroService bairroService) {
        this.bairroService = bairroService;
    }

    @GetMapping("")
    public List<Bairro> getBairros() {
        return bairroService.allBairros();
    }

    @GetMapping("/{id}")
    public Bairro getBairroId(@PathVariable Integer id) {
       return  bairroService.bairroId(id);
    }
    
    @PostMapping("")
    public String postBairro(@RequestBody Bairro bairro) {
        bairroService.salvarBairro(bairro);
        return "Dados Salvos com Sucesso!!!";
    }
    
    @DeleteMapping("/{id}")
    public String deletaId(@PathVariable Integer id){
        bairroService.apagaId(id);
        return "O bairro de código: "+ id + " foi deletado";
    }
    
    @PutMapping("/{id}")
    public String putBairro(@PathVariable Integer id, @RequestBody Bairro bairro) {
        //TODO: process PUT request
        bairroService.editarBairro(id, bairro);
        return "Dados atualizados com sucesso!";
    }
}
