package com.projetos.mentoria.biblioteca.infra.repository;


import com.projetos.mentoria.biblioteca.infra.repository.entities.BookItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LivroRepository extends JpaRepository<BookItem, String> {
}