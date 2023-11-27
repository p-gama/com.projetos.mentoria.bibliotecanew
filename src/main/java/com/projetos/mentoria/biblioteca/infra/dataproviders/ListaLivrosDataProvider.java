package com.projetos.mentoria.biblioteca.infra.dataproviders;

import com.projetos.mentoria.biblioteca.domain.entities.ListaLivrosEntity;
import com.projetos.mentoria.biblioteca.domain.exception.NaoEncontradoException;
import com.projetos.mentoria.biblioteca.infra.dataproviders.mapper.ListaLivrosEntityMapper;
import com.projetos.mentoria.biblioteca.domain.gateways.ListaLivrosGateway;
import com.projetos.mentoria.biblioteca.infra.repository.ListaLivrosRepository;
import com.projetos.mentoria.biblioteca.infra.repository.LivroRepository;
import com.projetos.mentoria.biblioteca.infra.repository.entities.ListaLivros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListaLivrosDataProvider implements ListaLivrosGateway {

    @Autowired
    private ListaLivrosRepository listaLivrosRepository;
    private final ListaLivrosEntityMapper listaLivrosEntityMapper;
    @Autowired
    private LivroRepository livroRepository;

    public ListaLivrosDataProvider(ListaLivrosRepository listaLivrosRepository, ListaLivrosEntityMapper listaLivrosEntityMapper, LivroRepository livroRepository) {
        this.listaLivrosRepository = listaLivrosRepository;
        this.listaLivrosEntityMapper = listaLivrosEntityMapper;
        this.livroRepository = livroRepository;
    }


    public ListaLivrosEntity criarLista(ListaLivrosEntity lista) {
        var listaDb = listaLivrosEntityMapper.toListaLivros(lista);
        var listaSalva = listaLivrosRepository.save(listaDb);
        return listaLivrosEntityMapper.toListaLivrosEntity(listaSalva);
    }

    public List<ListaLivrosEntity> listarListas() {
        List<ListaLivros> listaLivros = listaLivrosRepository.findAll();
        return  listaLivros.stream()
                .map(listaLivrosEntityMapper::toListaLivrosEntity)
                .collect(Collectors.toList());
    }

    public List<ListaLivrosEntity> listarListasPorCliente(Long clienteId) {
        List<ListaLivros> listaLivros = listaLivrosRepository.findByClienteId(clienteId);
        return listaLivros.stream()
                .map(listaLivrosEntityMapper::toListaLivrosEntity)
                .collect(Collectors.toList());
    }

    public ListaLivrosEntity buscarListaPorId(Long listaId) {
        return listaLivrosEntityMapper.toListaLivrosEntity(listaLivrosRepository.findById(listaId)
                .orElseThrow(() -> new NaoEncontradoException("Lista não encontrada")));
    }

    public ListaLivrosEntity salvarLista(ListaLivrosEntity lista) {
        ListaLivros listaLivrosToSave = listaLivrosEntityMapper.toListaLivros(lista);
        ListaLivros savedLista = listaLivrosRepository.save(listaLivrosToSave);
        return listaLivrosEntityMapper.toListaLivrosEntity(savedLista);
    }
}
