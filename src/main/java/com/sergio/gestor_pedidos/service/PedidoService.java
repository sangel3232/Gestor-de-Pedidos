package com.sergio.gestor_pedidos.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sergio.gestor_pedidos.model.Cliente;
import com.sergio.gestor_pedidos.model.Pedido;
import com.sergio.gestor_pedidos.repository.ClienteRepository;
import com.sergio.gestor_pedidos.repository.PedidoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;

    public Pedido crearPedido(Pedido pedido) {

        // Validación básica
        if (pedido.getCliente() == null || pedido.getCliente().getId() == null) {
            throw new IllegalArgumentException("Debe enviar el cliente con su id. Ej: \"cliente\": { \"id\": 1 }");
        }

        Long clienteId = pedido.getCliente().getId();

        // Traer el cliente real desde BD (para que NO quede con nulls)
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con id: " + clienteId));

        // Asignar cliente completo
        pedido.setCliente(cliente);

        // Si quieres que el servidor ponga siempre la fecha y estado:
        pedido.setFecha(LocalDateTime.now());
        pedido.setEstado("CREADO");

        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public List<Pedido> buscarPorEstado(String estado) {
        return pedidoRepository.findByEstado(estado);
    }

    public void eliminarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}