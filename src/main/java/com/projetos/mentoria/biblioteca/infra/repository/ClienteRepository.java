package com.projetos.mentoria.biblioteca.infra.repository;

import com.projetos.mentoria.biblioteca.infra.repository.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByCpf(String cpf);
}