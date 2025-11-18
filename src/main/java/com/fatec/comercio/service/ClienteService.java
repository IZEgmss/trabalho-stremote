package com.fatec.comercio.service;

import com.fatec.comercio.forms.ClienteForm;
import com.fatec.comercio.models.*;
import com.fatec.comercio.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {
    @Autowired private ClienteRepository clienteRepository;
    @Autowired private SexoRepository sexoRepository;
    @Autowired private RuaRepository ruaRepository;
    @Autowired private CidadeRepository cidadeRepository;
    @Autowired private BairroRepository bairroRepository;
    @Autowired private CepRepository cepRepository;

    public ClienteService(ClienteRepository clienteRepository, SexoRepository sexoRepository,
                          RuaRepository ruaRepository, CidadeRepository cidadeRepository,
                          BairroRepository bairroRepository, CepRepository cepRepository){
        this.clienteRepository = clienteRepository;
        this.sexoRepository = sexoRepository;
        this.ruaRepository = ruaRepository;
        this.cidadeRepository = cidadeRepository;
        this.bairroRepository = bairroRepository;
        this.cepRepository = cepRepository;
    }

    public List<Cliente> buscarClientes(){ return clienteRepository.findAll(); }
    public Cliente buscarClientePorId(Integer id){ return clienteRepository.findByCodcliente(id); }


    @Transactional
    public Cliente salvarCliente(ClienteForm form){

        Sexo sexo = sexoRepository.findById(form.getCodsexo())
                .orElseThrow(() -> new RuntimeException("Sexo não encontrado com ID: " + form.getCodsexo()));

        Rua rua = ruaRepository.findById(form.getCodrua())
                .orElseThrow(() -> new RuntimeException("Rua não encontrada com ID: " + form.getCodrua()));

        Cidade cidade = cidadeRepository.findById(form.getCodcidade())
                .orElseThrow(() -> new RuntimeException("Cidade não encontrada com ID: " + form.getCodcidade()));

        Bairro bairro = bairroRepository.findById(form.getCodbairro())
                .orElseThrow(() -> new RuntimeException("Bairro não encontrado com ID: " + form.getCodbairro()));

        Cep cep = cepRepository.findById(form.getCodcep())
                .orElseThrow(() -> new RuntimeException("CEP não encontrado com ID: " + form.getCodcep()));

        Cliente cliente = new Cliente();
        cliente.setNomecliente(form.getNomecliente());
        cliente.setCpfcliente(form.getCpfcliente());
        cliente.setDatanasc(form.getDatanasc());
        cliente.setNumerocasa(form.getNumerocasa());
        cliente.setSexo(sexo);
        cliente.setRua(rua);
        cliente.setCidade(cidade);
        cliente.setBairro(bairro);
        cliente.setCep(cep);


        return clienteRepository.save(cliente);
    }


    @Transactional
    public void editarCliente(Integer id, ClienteForm form){
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID: " + id));
        Sexo sexo = sexoRepository.findById(form.getCodsexo()).orElse(null);
        Rua rua = ruaRepository.findById(form.getCodrua()).orElse(null);
        Cidade cidade = cidadeRepository.findById(form.getCodcidade()).orElse(null);
        Bairro bairro = bairroRepository.findById(form.getCodbairro()).orElse(null);
        Cep cep = cepRepository.findById(form.getCodcep()).orElse(null);

        cliente.setNomecliente(form.getNomecliente());
        cliente.setCpfcliente(form.getCpfcliente());
        cliente.setDatanasc(form.getDatanasc());
        cliente.setNumerocasa(form.getNumerocasa());
        cliente.setSexo(sexo);
        cliente.setRua(rua);
        cliente.setCidade(cidade);
        cliente.setBairro(bairro);
        cliente.setCep(cep);

        clienteRepository.save(cliente);
    }

    public void apagarCliente(Integer id){
        clienteRepository.deleteById(id);
    }
}