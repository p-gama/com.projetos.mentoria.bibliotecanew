package com.projetos.mentoria.biblioteca.domain.gateways;

import com.projetos.mentoria.biblioteca.domain.entities.ListaLivrosEntity;
import com.projetos.mentoria.biblioteca.infra.repository.entities.ListaLivros;

import java.util.List;

public interface ListaLivrosGateway {

    ListaLivrosEntity criarLista(ListaLivrosEntity lista);

    List<ListaLivrosEntity> listarListas();

    List<ListaLivrosEntity> listarListasPorCliente(Long clienteId);

    ListaLivrosEntity buscarListaPorId(Long listaId);

    ListaLivrosEntity salvarLista(ListaLivrosEntity lista);
}
