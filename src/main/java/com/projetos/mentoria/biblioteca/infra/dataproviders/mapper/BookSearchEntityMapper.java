package com.projetos.mentoria.biblioteca.infra.dataproviders.mapper;

import com.projetos.mentoria.biblioteca.domain.entities.BookSearchEntity;
import com.projetos.mentoria.biblioteca.infra.repository.entities.BookSearch;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookSearchEntityMapper {

    BookSearchEntity toBookSearchEntity (BookSearch bookSearch);
    BookSearch toBookSearch (BookSearchEntity bookSearchEntity);


}
