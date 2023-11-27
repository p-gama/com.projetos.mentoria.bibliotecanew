package com.projetos.mentoria.biblioteca.application.mapper;

import com.projetos.mentoria.biblioteca.application.model.BookSearchResponse;
import com.projetos.mentoria.biblioteca.domain.entities.BookSearchEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookSearchMapper {

    BookSearchResponse toBookSearchResponse (BookSearchEntity bookSearch);
    BookSearchEntity toBookSearchEntity (BookSearchResponse bookSearchResponse);


}