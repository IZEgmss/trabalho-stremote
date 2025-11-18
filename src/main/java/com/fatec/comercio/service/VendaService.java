package com.fatec.comercio.service;

import com.fatec.comercio.forms.ItemVendaForm;
import com.fatec.comercio.forms.VendaForm;
import com.fatec.comercio.models.*;
import com.fatec.comercio.repository.ClienteRepository;
import com.fatec.comercio.repository.ProdutoRepository;
import com.fatec.comercio.repository.VendaRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal; // Importe BigDecimal
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private EntityManager entityManager;

    public VendaService(VendaRepository vendaRepository, ClienteRepository clienteRepository, ProdutoRepository produtoRepository) {
        this.vendaRepository = vendaRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    public List<Venda> buscarTodasVendas() {
        return vendaRepository.findAll();
    }

    public Venda buscarVendaPorId(Integer id) {
        return vendaRepository.findById(id).orElse(null);
    }

    // ===================================
    // === METODO SALVAR (ATUALIZADO) ===
    // ===================================
    @Transactional
    public Venda salvarVenda(VendaForm form) {
        Cliente cliente = clienteRepository.findById(form.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID: " + form.getClienteId()));

        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setDatavenda(new Date());

        List<VendaProduto> itens = processarItens(venda, form.getItens());
        venda.setItens(itens);
        return vendaRepository.save(venda);
    }

    // ===================================
    // === NOVO MÉTODO ATUALIZAR ===
    // ===================================
    @Transactional
    public Venda atualizarVenda(Integer id, VendaForm form) {
        // 1. Busca a venda existente
        Venda venda = vendaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada com ID: " + id));

        // 2. Devolve os itens antigos ao estoque
        restaurarEstoque(venda.getItens());

        // 3. (Opcional) Atualiza o cliente se mudou
        if (!venda.getCliente().getCodcliente().equals(form.getClienteId())) {
            Cliente novoCliente = clienteRepository.findById(form.getClienteId())
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID: " + form.getClienteId()));
            venda.setCliente(novoCliente);
        }

        // 4. Limpa a lista antiga (graças ao orphanRemoval=true, eles serão excluídos)
        venda.getItens().clear();

        // ===================================
        // === ADICIONE ESTA LINHA (A CORREÇÃO) ===
        // ===================================
        entityManager.flush();
        // ===================================

        // 5. Processa e subtrai os novos itens do estoque
        List<VendaProduto> novosItens = processarItens(venda, form.getItens());
        venda.getItens().addAll(novosItens);

        // 6. Salva a venda atualizada
        return vendaRepository.save(venda); // Esta linha (linha 86) estava causando o erro no commit
    }

    // ===================================
    // === NOVO METODO APAGAR ===
    // ===================================
    @Transactional
    public void apagarVenda(Integer id) {
        // 1. Busca a venda
        Venda venda = vendaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada com ID: " + id));

        // 2. Devolve os itens da venda ao estoque
        restaurarEstoque(venda.getItens());

        // 3. Apaga a venda (os VendaProduto serão apagados em cascata)
        vendaRepository.delete(venda);
    }

    // ===================================
    // === LÓGICA DE ESTOQUE E VALOR ===
    // ===================================

    /**
     * Processa os itens da venda, subtrai do estoque e calcula o valor.
     */
    private List<VendaProduto> processarItens(Venda venda, List<ItemVendaForm> itensForm) {
        List<VendaProduto> itens = new ArrayList<>();

        for (ItemVendaForm itemForm : itensForm) {
            Produto produto = produtoRepository.findById(itemForm.getProdutoId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + itemForm.getProdutoId()));

            BigDecimal quantidadeVendida = itemForm.getQuantidade();

            // 1. VERIFICA ESTOQUE
            if (produto.getQuantidade().compareTo(quantidadeVendida) < 0) {
                // compareTo < 0 significa que o estoque é menor que a quantidade vendida
                throw new RuntimeException("Estoque insuficiente para o produto: " + produto.getNomeproduto());
            }

            // 2. SUBTRAI DO ESTOQUE
            produto.setQuantidade(produto.getQuantidade().subtract(quantidadeVendida));
            produtoRepository.save(produto); // Salva o estoque atualizado

            // 3. CALCULA O VALOR TOTAL DO ITEM
            // (Assumindo que produto.getValor() é o PREÇO UNITÁRIO)
            BigDecimal valorTotalItem = produto.getValor().multiply(quantidadeVendida);

            // 4. CRIA O ITEM DA VENDA
            VendaProduto vendaProduto = new VendaProduto();
            vendaProduto.setId(new VendaProdutoId()); // Não se esqueça disso!
            vendaProduto.setVenda(venda);
            vendaProduto.setProduto(produto);
            vendaProduto.setQuantidadeVendida(quantidadeVendida);
            vendaProduto.setValorVenda(valorTotalItem); // Salva o valor total (Qtd * Preço)

            itens.add(vendaProduto);
        }
        return itens;
    }

    /**
     * Devolve os itens de uma lista de VendaProduto ao estoque.
     */
    private void restaurarEstoque(List<VendaProduto> itens) {
        for (VendaProduto item : itens) {
            Produto produto = item.getProduto();
            BigDecimal quantidadeDevolvida = item.getQuantidadeVendida();

            produto.setQuantidade(produto.getQuantidade().add(quantidadeDevolvida));
            produtoRepository.save(produto);
        }
    }
}