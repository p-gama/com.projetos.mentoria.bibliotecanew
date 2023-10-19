package com.projetos.mentoria.biblioteca.infra.dataproviders.mapper;

import com.projetos.mentoria.biblioteca.domain.entities.BookItemEntity;
import com.projetos.mentoria.biblioteca.domain.entities.BookSearchEntity;
import com.projetos.mentoria.biblioteca.domain.entities.ListaLivrosEntity;
import com.projetos.mentoria.biblioteca.domain.entities.VolumeInfoEntity;
import com.projetos.mentoria.biblioteca.infra.repository.entities.BookItem;
import com.projetos.mentoria.biblioteca.infra.repository.entities.BookSearch;
import com.projetos.mentoria.biblioteca.infra.repository.entities.ListaLivros;
import com.projetos.mentoria.biblioteca.infra.repository.entities.VolumeInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LivroEntityMapper {

    BookItemEntity toBookItemEntity (BookItem bookItem);
    BookItem toBookItem (BookItemEntity bookItemEntity);


    VolumeInfoEntity toVolumeInfoEntity (VolumeInfo volumeInfo);
    VolumeInfo toVolumeInfo (VolumeInfoEntity volumeInfoEntity);

    BookSearchEntity toBookSearchEntity (BookSearch bookSearch);
    BookSearch toBookSearch (BookSearchEntity bookSearchEntity);

    ListaLivrosEntity toListaLivrosEntity (ListaLivros listaLivros);
    ListaLivros toListaLivros (ListaLivrosEntity listaLivrosEntity);
}