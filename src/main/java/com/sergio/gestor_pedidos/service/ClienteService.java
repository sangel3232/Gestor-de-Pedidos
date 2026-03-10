package com.sergio.gestor_pedidos.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.sergio.gestor_pedidos.repository.ClienteRepository;
import com.sergio.gestor_pedidos.model.Cliente;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    // Esta función es para la creación del cliente
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    //Esta función es para el listado de clientes :3
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }
}