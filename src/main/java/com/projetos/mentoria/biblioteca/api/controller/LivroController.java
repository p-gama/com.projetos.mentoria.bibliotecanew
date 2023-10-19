package com.projetos.mentoria.biblioteca.api.controller;

import com.projetos.mentoria.biblioteca.application.model.BookItemResponse;
import com.projetos.mentoria.biblioteca.application.model.BookSearchResponse;
import com.projetos.mentoria.biblioteca.application.usecases.LivroUseCase;
import com.projetos.mentoria.biblioteca.domain.entities.BookItemEntity;
import com.projetos.mentoria.biblioteca.domain.entities.BookSearchEntity;
import com.projetos.mentoria.biblioteca.infra.repository.entities.BookItem;
import com.projetos.mentoria.biblioteca.application.mapper.LivroMapper;
import com.projetos.mentoria.biblioteca.infra.repository.entities.BookSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class LivroController {
    private final LivroUseCase livroUseCase;

    private final LivroMapper livroMapper;

    @Autowired
    public LivroController(LivroUseCase livroUseCase, LivroMapper livroMapper) {
        this.livroUseCase = livroUseCase;
        this.livroMapper = livroMapper;
    }

    @GetMapping("/search")
    public ResponseEntity<BookSearchResponse> searchBooks(@RequestParam("query") String query) {
        BookSearchEntity searchEntity = livroUseCase.searchBooks(query);
        BookSearchResponse result = livroMapper.toBookSearchResponse(searchEntity);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookItemResponse> getBookById(@PathVariable String bookId) {
        BookItemEntity livro = livroUseCase.searchBookById(bookId);

        if (livro == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(livroMapper.toBookItemResponse(livro));
    }
}