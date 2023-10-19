package com.projetos.mentoria.biblioteca.infra.repository;

import com.projetos.mentoria.biblioteca.infra.repository.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, String> {

}