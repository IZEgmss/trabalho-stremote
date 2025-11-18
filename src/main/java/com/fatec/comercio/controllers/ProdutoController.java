package com.fatec.comercio.controllers;

import com.fatec.comercio.models.Produto;
import com.fatec.comercio.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("")
    public List<Produto> getTodosProdutos() {
        return produtoService.buscarTodosProdutos();
    }

    @GetMapping("/{id}")
    public Produto getProdutoPorId(@PathVariable Integer id) {
        return produtoService.buscarProdutoPorId(id);
    }

    @PostMapping("")
    public Produto postProduto(@RequestBody Produto produto) {
        return produtoService.salvarProduto(produto);
    }

    @PutMapping("/{id}")
    public String putProduto(@PathVariable Integer id, @RequestBody Produto produto) {
        produtoService.editarProduto(id, produto);
        return "Dados do produto atualizados com sucesso!";
    }

    @DeleteMapping("/{id}")
    public String deleteProduto(@PathVariable Integer id) {
        produtoService.apagarProduto(id);
        return "O produto de código: " + id + " foi deletado.";
    }
}
