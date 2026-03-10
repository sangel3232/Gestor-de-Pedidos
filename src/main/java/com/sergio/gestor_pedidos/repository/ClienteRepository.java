package com.sergio.gestor_pedidos.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.sergio.gestor_pedidos.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
} 
