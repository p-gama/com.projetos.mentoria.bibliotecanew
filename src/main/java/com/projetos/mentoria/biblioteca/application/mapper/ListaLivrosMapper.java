package com.projetos.mentoria.biblioteca.application.mapper;

import com.projetos.mentoria.biblioteca.application.model.*;
import com.projetos.mentoria.biblioteca.domain.entities.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ListaLivrosMapper {

    ListaLivrosEntity toListaLivrosEntity (ListaLivrosResponse listaLivrosResponse);

    ListaLivrosResponse toListaLivrosResponse  (ListaLivrosEntity listaLivros);
}