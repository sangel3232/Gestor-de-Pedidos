package com.sergio.gestor_pedidos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sergio.gestor_pedidos.model.Pedido;
import com.sergio.gestor_pedidos.service.PedidoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class Pedidocontroller {

    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Pedido pedido) {
        try {
            return ResponseEntity.ok(pedidoService.crearPedido(pedido));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<Pedido> listar() {
        return pedidoService.listarPedidos();
    }

    @GetMapping("/estado/{estado}")
    public List<Pedido> porEstado(@PathVariable String estado) {
        return pedidoService.buscarPorEstado(estado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        pedidoService.eliminarPedido(id);
    }
}