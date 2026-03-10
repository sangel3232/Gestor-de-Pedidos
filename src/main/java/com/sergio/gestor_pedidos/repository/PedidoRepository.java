package com.sergio.gestor_pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sergio.gestor_pedidos.model.Pedido;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByEstado(String estado);

    List<Pedido> findByCliente_Ciudad(String ciudad);
}