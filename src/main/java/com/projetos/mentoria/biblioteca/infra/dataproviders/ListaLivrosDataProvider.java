package com.projetos.mentoria.biblioteca.infra.dataproviders;

import com.projetos.mentoria.biblioteca.domain.entities.BookItemEntity;
import com.projetos.mentoria.biblioteca.domain.entities.ClienteEntity;
import com.projetos.mentoria.biblioteca.domain.entities.ListaLivrosEntity;
import com.projetos.mentoria.biblioteca.domain.exception.NaoEncontradoException;
import com.projetos.mentoria.biblioteca.infra.dataproviders.mapper.LivroEntityMapper;
import com.projetos.mentoria.biblioteca.domain.gateways.ListaLivrosGateway;
import com.projetos.mentoria.biblioteca.infra.repository.ListaLivrosRepository;
import com.projetos.mentoria.biblioteca.infra.repository.LivroRepository;
import com.projetos.mentoria.biblioteca.infra.repository.entities.Cliente;
import com.projetos.mentoria.biblioteca.infra.repository.entities.ListaLivros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ListaLivrosDataProvider implements ListaLivrosGateway {

    @Autowired
    private ListaLivrosRepository listaLivrosRepository;
    private final LivroEntityMapper livroEntityMapper;
    @Autowired
    private LivroRepository livroRepository;

    public ListaLivrosDataProvider(ListaLivrosRepository listaLivrosRepository, LivroEntityMapper livroEntityMapper) {
        this.listaLivrosRepository = listaLivrosRepository;
        this.livroEntityMapper = livroEntityMapper;
    }

    public ListaLivrosEntity criarLista(ListaLivrosEntity lista) {
        var listaDb = livroEntityMapper.toListaLivros(lista);
        var listaSalva = listaLivrosRepository.save(listaDb);
        return livroEntityMapper.toListaLivrosEntity(listaSalva);
    }

    public List<ListaLivrosEntity> listarListas() {
        List<ListaLivros> listaLivros = listaLivrosRepository.findAll();
        return  listaLivros.stream()
                .map(livroEntityMapper::toListaLivrosEntity)
                .collect(Collectors.toList());
    }

    public List<ListaLivrosEntity> listarListasPorCliente(Long clienteId) {
        List<ListaLivros> listaLivros = listaLivrosRepository.findByClienteId(clienteId);
        return listaLivros.stream()
                .map(livroEntityMapper::toListaLivrosEntity)
                .collect(Collectors.toList());
    }

    public ListaLivrosEntity buscarListaPorId(Long listaId) {
        return livroEntityMapper.toListaLivrosEntity(listaLivrosRepository.findById(listaId)
                .orElseThrow(() -> new NaoEncontradoException("Lista não encontrada")));
    }

    public ListaLivrosEntity salvarLista(ListaLivrosEntity lista) {
        ListaLivros listaLivrosToSave = livroEntityMapper.toListaLivros(lista);
        ListaLivros savedLista = listaLivrosRepository.save(listaLivrosToSave);
        return livroEntityMapper.toListaLivrosEntity(savedLista);
    }
}
