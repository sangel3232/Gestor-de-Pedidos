package com.sergio.gestor_pedidos.controller;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import com.sergio.gestor_pedidos.service.ClienteService;
import com.sergio.gestor_pedidos.model.Cliente;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public Cliente crear(@RequestBody Cliente cliente) {
        return clienteService.crearCliente(cliente);
    }

    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listarClientes();
    }
}