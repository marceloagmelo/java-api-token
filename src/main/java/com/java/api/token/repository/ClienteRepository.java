package com.java.api.token.repository;

import com.java.api.token.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query(value = "select id, nome from cliente where nome = :nome", nativeQuery = true)
    Cliente findByNomeCliente(String nome);

    @Query(value = "select id, nome from cliente where id = :id", nativeQuery = true)
    Cliente findByIdCliente(Integer id);
}
