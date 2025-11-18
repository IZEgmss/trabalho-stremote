package com.fatec.comercio.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.comercio.models.Marca;
import com.fatec.comercio.service.MarcaService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/marcas")

public class MarcaController {
     private final MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping("")
    public List<Marca> getMarcas() {
        return marcaService.allMarcas();
    }

    @GetMapping("/{id}")
    public Marca getMarcaId(@PathVariable Integer id) {
       return  marcaService.marcaId(id);
    }
    
    @PostMapping("")
    public String postMarca(@RequestBody Marca marca) {
        marcaService.salvarMarca(marca);
        return "Dados Salvos com Sucesso!!!";
    }
    
    @DeleteMapping("/{id}")
    public String deletaId(@PathVariable Integer id){
        marcaService.apagaId(id);
        return "A marca de código: "+ id + " foi deletado";
    }
    
    @PutMapping("/{id}")
    public String putMarca(@PathVariable Integer id, @RequestBody Marca marca) {
        //TODO: process PUT request
        marcaService.editarMarca(id, marca);
        return "Dados atualizados com sucesso!";
    }
}
