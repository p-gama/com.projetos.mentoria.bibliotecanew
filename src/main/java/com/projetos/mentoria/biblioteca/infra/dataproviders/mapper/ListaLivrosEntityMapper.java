package com.projetos.mentoria.biblioteca.infra.dataproviders.mapper;

import com.projetos.mentoria.biblioteca.domain.entities.ListaLivrosEntity;
import com.projetos.mentoria.biblioteca.infra.repository.entities.ListaLivros;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ListaLivrosEntityMapper {
    ListaLivrosEntity toListaLivrosEntity (ListaLivros listaLivros);
    ListaLivros toListaLivros (ListaLivrosEntity listaLivrosEntity);
}