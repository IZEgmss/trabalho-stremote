package com.fatec.comercio.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.comercio.forms.CidadeForm;
import com.fatec.comercio.models.Cidade;
import com.fatec.comercio.service.CidadeService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/cidades")
public class CidadeController {
    private final CidadeService cidadeService;

    CidadeController(CidadeService cidadeService){
        this.cidadeService = cidadeService;
    }

    @GetMapping("")
    public List <Cidade> getCidades() {
        return cidadeService.allCidades();
    }

    @GetMapping("/{id}")
    public Cidade getCidadeId(@RequestParam Integer id) {
        return cidadeService.cidadeId(id);
    }
    
    @GetMapping("/{nomecidade}")
    public Cidade getNomecidade(@RequestParam String nomecidade) {
        return cidadeService.cidadeNomecidade(nomecidade);
    }
    

    @DeleteMapping("/{id}")
    public void deleteCidadeId(@PathVariable Integer id){
        cidadeService.apagaCidadeId(id);
    }

    @PutMapping("/{id}")
    public Cidade putCidadeId(@PathVariable Integer id, @RequestBody CidadeForm cidadeForm) {
        
        return cidadeService.editaCidade(cidadeForm, id);
    }

    @PostMapping("")
    public Cidade postCidade(@RequestBody CidadeForm cidadeForm) {
        return cidadeService.salvarCidade(cidadeForm);
    }
    
    
}
