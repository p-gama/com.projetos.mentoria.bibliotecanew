package com.projetos.mentoria.biblioteca.infra.dataproviders;

import com.projetos.mentoria.biblioteca.domain.entities.BookItemEntity;
import com.projetos.mentoria.biblioteca.domain.entities.BookSearchEntity;
import com.projetos.mentoria.biblioteca.infra.dataproviders.mapper.LivroEntityMapper;
import com.projetos.mentoria.biblioteca.infra.repository.entities.BookItem;
import com.projetos.mentoria.biblioteca.domain.gateways.LivroGateway;
import com.projetos.mentoria.biblioteca.infra.clients.GoogleBooksApiClient;
import com.projetos.mentoria.biblioteca.infra.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LivroDataProvider implements LivroGateway {

    @Autowired
    private final LivroRepository livroRepository;

    private final GoogleBooksApiClient googleBooksApiClient;

    private final LivroEntityMapper livroEntityMapper;

    public LivroDataProvider(LivroRepository livroRepository, GoogleBooksApiClient googleBooksApiClient, LivroEntityMapper livroEntityMapper) {
        this.livroRepository = livroRepository;
        this.googleBooksApiClient = googleBooksApiClient;
        this.livroEntityMapper = livroEntityMapper;
    }


    @Override
    public BookItemEntity salvarLivro(BookItemEntity book) {
        var livro = livroEntityMapper.toBookItem(book);
        var livroSalvo = livroRepository.save(livro);
        return livroEntityMapper.toBookItemEntity(livroSalvo);
    }

    @Override
    public BookItemEntity searchBookById(String bookId) {
        return livroEntityMapper.toBookItemEntity(googleBooksApiClient.searchBookById(bookId));
    }

    @Override
    public BookSearchEntity searchBooks(String query) {
        return livroEntityMapper.toBookSearchEntity(googleBooksApiClient.searchBooks(query));
    }
}
