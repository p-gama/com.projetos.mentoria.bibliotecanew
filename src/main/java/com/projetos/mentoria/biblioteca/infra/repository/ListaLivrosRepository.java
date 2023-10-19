package com.projetos.mentoria.biblioteca.infra.repository;


import com.projetos.mentoria.biblioteca.infra.repository.entities.ListaLivros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListaLivrosRepository extends JpaRepository<ListaLivros, Long> {
    @Query("SELECT bl FROM ListaLivros bl WHERE bl.cliente.idPessoa = :clienteId")
    List<ListaLivros> findByClienteId(Long clienteId);

}