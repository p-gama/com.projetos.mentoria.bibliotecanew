package com.projetos.mentoria.biblioteca.domain.entities;

import com.projetos.mentoria.biblioteca.infra.repository.entities.BookItem;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookSearchEntity {
    private List<BookItemEntity> items;

}