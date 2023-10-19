package com.projetos.mentoria.biblioteca.application.mapper;

import com.projetos.mentoria.biblioteca.application.model.*;
import com.projetos.mentoria.biblioteca.domain.entities.*;
import com.projetos.mentoria.biblioteca.infra.repository.entities.BookSearch;
import com.projetos.mentoria.biblioteca.infra.repository.entities.VolumeInfo;
import com.projetos.mentoria.biblioteca.infra.repository.entities.ListaLivros;
import com.projetos.mentoria.biblioteca.infra.repository.entities.BookItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LivroMapper {

    BookItemEntity toBookItemEntity (BookItemResponse bookItemResponse);

    BookItemResponse toBookItemResponse (BookItemEntity bookItem);

    VolumeInfoEntity toVolumeInfoEntity (VolumeInfoResponse volumeInfoResponse);

    VolumeInfoResponse toVolumeInfoResponse (VolumeInfoEntity volumeInfo);

    BookSearchResponse toBookSearchResponse (BookSearchEntity bookSearch);
    BookSearchEntity toBookSearchEntity (BookSearchResponse bookSearchResponse);

    ListaLivrosEntity toListaLivrosEntity (ListaLivrosResponse listaLivrosResponse);

    ListaLivrosResponse toListaLivrosResponse  (ListaLivrosEntity listaLivros);
}