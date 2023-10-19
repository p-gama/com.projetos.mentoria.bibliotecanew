package com.projetos.mentoria.biblioteca.application.usecases;

import com.projetos.mentoria.biblioteca.application.model.ListaLivrosResponse;
import com.projetos.mentoria.biblioteca.domain.entities.ListaLivrosEntity;
import com.projetos.mentoria.biblioteca.infra.repository.ListaLivrosRepository;
import com.projetos.mentoria.biblioteca.infra.repository.entities.ListaLivros;

import java.util.List;

public interface ListaLivrosUseCase {

    ListaLivrosEntity criarLista(ListaLivrosResponse lista);

    List<ListaLivrosEntity> listarListas();

    List<ListaLivrosEntity> listarListasPorCliente(Long clienteId);

    ListaLivrosEntity buscarListaPorId(Long listaId);

    ListaLivrosEntity salvarLista(ListaLivrosResponse lista);



}
