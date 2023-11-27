package com.projetos.mentoria.biblioteca.application.usecases.impl;

import com.projetos.mentoria.biblioteca.application.mapper.ListaLivrosMapper;
import com.projetos.mentoria.biblioteca.application.model.ListaLivrosResponse;
import com.projetos.mentoria.biblioteca.application.usecases.ListaLivrosUseCase;
import com.projetos.mentoria.biblioteca.domain.entities.ListaLivrosEntity;
import com.projetos.mentoria.biblioteca.domain.gateways.ListaLivrosGateway;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListaLivrosUseCaseImpl implements ListaLivrosUseCase {
    private final ListaLivrosGateway listaLivrosGateway;

    private final ListaLivrosMapper listaLivrosMapper;

    public ListaLivrosUseCaseImpl(ListaLivrosGateway listaLivrosGateway, ListaLivrosMapper listaLivrosMapper) {
        this.listaLivrosGateway = listaLivrosGateway;
        this.listaLivrosMapper = listaLivrosMapper;
    }

    @Override
    public ListaLivrosEntity criarLista(ListaLivrosResponse lista) {
        ListaLivrosEntity listaLivrosEntity = listaLivrosMapper.toListaLivrosEntity(lista);
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
        ListaLivrosEntity listaLivrosEntity = listaLivrosMapper.toListaLivrosEntity(lista);
        return listaLivrosGateway.salvarLista(listaLivrosEntity);

    }
}
