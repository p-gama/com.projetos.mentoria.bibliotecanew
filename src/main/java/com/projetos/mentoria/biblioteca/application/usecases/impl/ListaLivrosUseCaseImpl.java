package com.projetos.mentoria.biblioteca.application.usecases.impl;

import com.projetos.mentoria.biblioteca.application.mapper.LivroMapper;
import com.projetos.mentoria.biblioteca.application.model.ClienteDTO;
import com.projetos.mentoria.biblioteca.application.model.ListaLivrosResponse;
import com.projetos.mentoria.biblioteca.application.usecases.ListaLivrosUseCase;
import com.projetos.mentoria.biblioteca.application.usecases.LivroUseCase;
import com.projetos.mentoria.biblioteca.domain.entities.ClienteEntity;
import com.projetos.mentoria.biblioteca.domain.entities.ListaLivrosEntity;
import com.projetos.mentoria.biblioteca.infra.repository.entities.ListaLivros;
import com.projetos.mentoria.biblioteca.domain.gateways.ListaLivrosGateway;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class ListaLivrosUseCaseImpl implements ListaLivrosUseCase {
    private final ListaLivrosGateway listaLivrosGateway;

    private final LivroMapper livroMapper;

    public ListaLivrosUseCaseImpl(ListaLivrosGateway listaLivrosGateway, LivroMapper livroMapper) {
        this.listaLivrosGateway = listaLivrosGateway;
        this.livroMapper = livroMapper;
    }

    @Override
    public ListaLivrosEntity criarLista(ListaLivrosResponse lista) {
        ListaLivrosEntity listaLivrosEntity = livroMapper.toListaLivrosEntity(lista);
        return listaLivrosGateway.criarLista(listaLivrosEntity);
    }

    @Override
    public List<ListaLivrosEntity> listarListas() {
        return listaLivrosGateway.listarListas();
    }

    @Override
    public List<ListaLivrosEntity> listarListasPorCliente(Long clienteId) {
        return listaLivrosGateway.listarListasPorCliente(clienteId);
    }

    @Override
    public ListaLivrosEntity buscarListaPorId(Long listaId) {
        return listaLivrosGateway.buscarListaPorId(listaId);
    }
    @Override
    public ListaLivrosEntity salvarLista(ListaLivrosResponse lista) {
        ListaLivrosEntity listaLivrosEntity = livroMapper.toListaLivrosEntity(lista);
        return listaLivrosGateway.salvarLista(listaLivrosEntity);

    }
}
