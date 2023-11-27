package com.projetos.mentoria.biblioteca.infra.dataproviders;

import com.projetos.mentoria.biblioteca.domain.entities.BookItemEntity;
import com.projetos.mentoria.biblioteca.domain.entities.BookSearchEntity;
import com.projetos.mentoria.biblioteca.infra.dataproviders.mapper.BookItemEntityMapper;
import com.projetos.mentoria.biblioteca.infra.dataproviders.mapper.BookSearchEntityMapper;
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

    private final BookItemEntityMapper bookItemEntityMapper;

    private final BookSearchEntityMapper bookSearchEntityMapper;

    public LivroDataProvider(LivroRepository livroRepository, GoogleBooksApiClient googleBooksApiClient, BookItemEntityMapper bookItemEntityMapper, BookSearchEntityMapper bookSearchEntityMapper) {
        this.livroRepository = livroRepository;
        this.googleBooksApiClient = googleBooksApiClient;
        this.bookItemEntityMapper = bookItemEntityMapper;
        this.bookSearchEntityMapper = bookSearchEntityMapper;
    }


    @Override
    public BookItemEntity salvarLivro(BookItemEntity book) {
        var livro = bookItemEntityMapper.toBookItem(book);
        var livroSalvo = livroRepository.save(livro);
        return bookItemEntityMapper.toBookItemEntity(livroSalvo);
    }

    @Override
    public BookItemEntity searchBookById(String bookId) {
        return bookItemEntityMapper.toBookItemEntity(googleBooksApiClient.searchBookById(bookId));
    }

    @Override
    public BookSearchEntity searchBooks(String query) {
        return bookSearchEntityMapper.toBookSearchEntity(googleBooksApiClient.searchBooks(query));
    }
}
