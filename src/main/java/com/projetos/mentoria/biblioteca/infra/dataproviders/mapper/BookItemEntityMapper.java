package com.projetos.mentoria.biblioteca.infra.dataproviders.mapper;

import com.projetos.mentoria.biblioteca.domain.entities.BookItemEntity;
import com.projetos.mentoria.biblioteca.infra.repository.entities.BookItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookItemEntityMapper {

    BookItemEntity toBookItemEntity (BookItem bookItem);

    BookItem toBookItem (BookItemEntity bookItemEntity);
}
