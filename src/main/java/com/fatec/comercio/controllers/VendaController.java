package com.fatec.comercio.controllers;

import com.fatec.comercio.forms.VendaForm;
import com.fatec.comercio.models.Venda;
import com.fatec.comercio.service.VendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    private final VendaService vendaService;

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @PostMapping("")
    public ResponseEntity<Venda> criarVenda(@RequestBody VendaForm form) {
        try {
            Venda novaVenda = vendaService.salvarVenda(form);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaVenda);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("")
    public List<Venda> getTodasVendas() {
        return vendaService.buscarTodasVendas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> getVendaPorId(@PathVariable Integer id) {
        Venda venda = vendaService.buscarVendaPorId(id);
        if (venda != null) {
            return ResponseEntity.ok(venda);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venda> atualizarVenda(@PathVariable Integer id, @RequestBody VendaForm form) {
        try {
            Venda vendaAtualizada = vendaService.atualizarVenda(id, form);
            return ResponseEntity.ok(vendaAtualizada);
        } catch (RuntimeException e) {
            System.err.println("ERRO NA ATUALIZAÇÃO DA VENDA: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarVenda(@PathVariable Integer id) {
        try {
            vendaService.apagarVenda(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}