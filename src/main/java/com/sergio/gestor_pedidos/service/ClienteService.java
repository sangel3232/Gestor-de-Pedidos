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

    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }
}