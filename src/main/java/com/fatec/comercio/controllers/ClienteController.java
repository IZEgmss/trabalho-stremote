package com.fatec.comercio.controllers;

import com.fatec.comercio.models.Cliente;
import com.fatec.comercio.service.ClienteService;
import com.fatec.comercio.forms.ClienteForm;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping("")
    public List<Cliente> getTodosClientes(){
        return clienteService.buscarClientes();
    }

    @GetMapping("/{id}")
    public Cliente getClientePorId(@PathVariable Integer id){
        return clienteService.buscarClientePorId(id);
    }

    @PostMapping("")
    public Cliente postCliente(@RequestBody ClienteForm form){
        return clienteService.salvarCliente(form);
    }

    @PutMapping("/{id}")
    public String putCliente(@PathVariable Integer id, @RequestBody ClienteForm form){
        clienteService.editarCliente(id, form);
        return "Dados do cliente atualizados com sucesso!";
    }

    @DeleteMapping("/{id}")
    public String deleteCliente(@PathVariable Integer id){
        clienteService.apagarCliente(id);
        return "O cliente de código" + id + "foi deletado";
    }
}