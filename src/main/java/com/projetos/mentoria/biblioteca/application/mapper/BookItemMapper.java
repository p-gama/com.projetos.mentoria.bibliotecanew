package com.projetos.mentoria.biblioteca.application.mapper;

import com.projetos.mentoria.biblioteca.application.model.BookItemResponse;
import com.projetos.mentoria.biblioteca.domain.entities.BookItemEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookItemMapper {

    BookItemEntity toBookItemEntity(BookItemResponse bookItemResponse);

    BookItemResponse toBookItemResponse(BookItemEntity bookItem);

}