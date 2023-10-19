package com.projetos.mentoria.biblioteca.domain.gateways;

import com.projetos.mentoria.biblioteca.domain.entities.BookItemEntity;
import com.projetos.mentoria.biblioteca.domain.entities.BookSearchEntity;
import com.projetos.mentoria.biblioteca.infra.repository.entities.BookItem;
import com.projetos.mentoria.biblioteca.infra.repository.entities.BookSearch;


public interface LivroGateway {

    BookItemEntity salvarLivro(BookItemEntity book);

    BookItemEntity searchBookById(String bookId);

    BookSearchEntity searchBooks(String query);
}
