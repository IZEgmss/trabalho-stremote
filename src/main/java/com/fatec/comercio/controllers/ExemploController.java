package com.fatec.comercio.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/exemplo")
public class ExemploController {

    @GetMapping("")
    public String getTodos() {
        return ("Bem Vindo ao método Get");
    }
    
    @DeleteMapping("/{id}")
    public String deletaId(@PathVariable Integer id){
        return "Você quer apagar o id = "+ id;
    }
    
    @PostMapping("")
    public String postExemplo() {
           
        return "Salvei o exemplo";
    }
    
    @PutMapping("")
    public String putExemplo() {

        return "Atualizei os Dados";
    }
}
