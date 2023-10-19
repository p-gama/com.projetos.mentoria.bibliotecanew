package com.projetos.mentoria.biblioteca.application.usecases.impl;

import com.projetos.mentoria.biblioteca.application.mapper.LivroMapper;
import com.projetos.mentoria.biblioteca.application.model.BookItemResponse;
import com.projetos.mentoria.biblioteca.application.model.ClienteDTO;
import com.projetos.mentoria.biblioteca.application.usecases.LivroUseCase;
import com.projetos.mentoria.biblioteca.domain.entities.BookItemEntity;
import com.projetos.mentoria.biblioteca.domain.entities.BookSearchEntity;
import com.projetos.mentoria.biblioteca.domain.entities.ClienteEntity;
import com.projetos.mentoria.biblioteca.domain.gateways.LivroGateway;
import org.springframework.stereotype.Component;

@Component
public class LivroUseCaseImpl implements LivroUseCase {
    private final LivroGateway livroGateway;

    private final LivroMapper livroMapper;

    public LivroUseCaseImpl(LivroGateway livroGateway, LivroMapper livroMapper) {
        this.livroGateway = livroGateway;
        this.livroMapper = livroMapper;
    }


    @Override
    public BookItemEntity salvarLivro(BookItemResponse book) {
        BookItemEntity bookItemEntity = livroMapper.toBookItemEntity(book);
        return livroGateway.salvarLivro(bookItemEntity);
    }

    @Override
    public BookItemEntity searchBookById(String bookId) {
        return livroGateway.searchBookById(bookId);
    }

    @Override
    public BookSearchEntity searchBooks(String query) {
        return livroGateway.searchBooks(query);
    }
}
