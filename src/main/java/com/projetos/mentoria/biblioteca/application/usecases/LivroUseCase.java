package com.projetos.mentoria.biblioteca.application.usecases;

import com.projetos.mentoria.biblioteca.application.model.BookItemResponse;
import com.projetos.mentoria.biblioteca.domain.entities.BookItemEntity;
import com.projetos.mentoria.biblioteca.domain.entities.BookSearchEntity;
import com.projetos.mentoria.biblioteca.infra.repository.entities.BookItem;
import com.projetos.mentoria.biblioteca.infra.repository.entities.BookSearch;
import com.projetos.mentoria.biblioteca.infra.repository.entities.ListaLivros;

import java.util.List;

public interface LivroUseCase {

    BookItemEntity salvarLivro(BookItemResponse book);

    BookItemEntity searchBookById(String bookId);

    BookSearchEntity searchBooks(String query);


}
