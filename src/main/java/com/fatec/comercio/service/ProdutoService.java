package com.fatec.comercio.service;

import com.fatec.comercio.models.Produto;
import com.fatec.comercio.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> buscarTodosProdutos() {
        return produtoRepository.findAll();
    }


    public Produto buscarProdutoPorId(Integer id) {
        return produtoRepository.findById(id).orElse(null);
    }


    public Produto salvarProduto(Produto produto) {

        return produtoRepository.save(produto);
    }


    public Produto editarProduto(Integer id, Produto produtoAtualizado) {
        return produtoRepository.findById(id)
                .map(produtoExistente -> {
                    produtoAtualizado.setCodproduto(id);
                    return produtoRepository.save(produtoAtualizado);
                }).orElse(null);
    }

    public void apagarProduto(Integer id) {
        produtoRepository.deleteById(id);
    }
}
