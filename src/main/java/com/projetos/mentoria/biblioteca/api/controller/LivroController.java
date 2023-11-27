package com.projetos.mentoria.biblioteca.api.controller;

import com.projetos.mentoria.biblioteca.application.mapper.BookItemMapper;
import com.projetos.mentoria.biblioteca.application.mapper.BookSearchMapper;
import com.projetos.mentoria.biblioteca.application.model.BookItemResponse;
import com.projetos.mentoria.biblioteca.application.model.BookSearchResponse;
import com.projetos.mentoria.biblioteca.application.usecases.LivroUseCase;
import com.projetos.mentoria.biblioteca.domain.entities.BookItemEntity;
import com.projetos.mentoria.biblioteca.domain.entities.BookSearchEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class LivroController {
    private final LivroUseCase livroUseCase;

    private final BookItemMapper bookItemMapper;

    private final BookSearchMapper bookSearchMapper;
    @Autowired
    public LivroController(LivroUseCase livroUseCase, BookItemMapper bookItemMapper, BookSearchMapper bookSearchMapper) {
        this.livroUseCase = livroUseCase;
        this.bookItemMapper = bookItemMapper;
        this.bookSearchMapper = bookSearchMapper;
    }


    @GetMapping("/search")
    public ResponseEntity<BookSearchResponse> searchBooks(@RequestParam("query") String query) {
        BookSearchEntity searchEntity = livroUseCase.searchBooks(query);
        BookSearchResponse result = bookSearchMapper.toBookSearchResponse(searchEntity);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookItemResponse> getBookById(@PathVariable String bookId) {
        BookItemEntity livro = livroUseCase.searchBookById(bookId);

        if (livro == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(bookItemMapper.toBookItemResponse(livro));
    }
}