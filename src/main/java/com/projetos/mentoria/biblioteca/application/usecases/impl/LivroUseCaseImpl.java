package com.projetos.mentoria.biblioteca.application.usecases.impl;

import com.projetos.mentoria.biblioteca.application.mapper.BookItemMapper;
import com.projetos.mentoria.biblioteca.application.model.BookItemResponse;
import com.projetos.mentoria.biblioteca.application.usecases.LivroUseCase;
import com.projetos.mentoria.biblioteca.domain.entities.BookItemEntity;
import com.projetos.mentoria.biblioteca.domain.entities.BookSearchEntity;
import com.projetos.mentoria.biblioteca.domain.gateways.LivroGateway;
import org.springframework.stereotype.Component;

@Component
public class LivroUseCaseImpl implements LivroUseCase {
    private final LivroGateway livroGateway;

    private final BookItemMapper bookItemMapper;

    public LivroUseCaseImpl(LivroGateway livroGateway, BookItemMapper bookItemMapper) {
        this.livroGateway = livroGateway;
        this.bookItemMapper = bookItemMapper;
    }


    @Override
    public BookItemEntity salvarLivro(BookItemResponse book) {
        BookItemEntity bookItemEntity = bookItemMapper.toBookItemEntity(book);
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
