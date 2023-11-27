package com.projetos.mentoria.biblioteca.api.controller;

import com.projetos.mentoria.biblioteca.application.mapper.ClienteMapper;
import com.projetos.mentoria.biblioteca.application.mapper.ListaLivrosMapper;
import com.projetos.mentoria.biblioteca.application.model.BookIdRequest;
import com.projetos.mentoria.biblioteca.application.model.ListaLivrosResponse;
import com.projetos.mentoria.biblioteca.application.usecases.ClienteUseCase;
import com.projetos.mentoria.biblioteca.application.usecases.ListaLivrosUseCase;
import com.projetos.mentoria.biblioteca.application.usecases.LivroUseCase;
import com.projetos.mentoria.biblioteca.domain.entities.BookItemEntity;
import com.projetos.mentoria.biblioteca.domain.entities.ClienteEntity;
import com.projetos.mentoria.biblioteca.domain.entities.ListaLivrosEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/listas")
public class ListaLivrosController {

    @Autowired
    private final ListaLivrosUseCase listaLivrosUseCase;

    @Autowired
    private final LivroUseCase livroUseCase;
    @Autowired
    private final ClienteUseCase clienteUseCase;

    private final ClienteMapper clienteMapper;

    private final ListaLivrosMapper listaLivrosMapper;


    public ListaLivrosController(ListaLivrosUseCase listaLivrosUseCase, LivroUseCase livroUseCase, ClienteUseCase clienteUseCase, ClienteMapper clienteMapper, ListaLivrosMapper listaLivrosMapper) {
        this.listaLivrosUseCase = listaLivrosUseCase;
        this.livroUseCase = livroUseCase;
        this.clienteUseCase = clienteUseCase;
        this.clienteMapper = clienteMapper;
        this.listaLivrosMapper = listaLivrosMapper;
    }

    @PostMapping
    public ResponseEntity<ListaLivrosResponse> criarLista(@RequestBody ListaLivrosResponse lista) {
        Optional<ClienteEntity> cliente = clienteUseCase.findById(lista.getCliente().getIdPessoa());

        if(cliente.isEmpty()) {
            return ResponseEntity.notFound().build();
           }

        ListaLivrosEntity novaLista = listaLivrosUseCase.criarLista(lista);
        novaLista.setCliente(lista.getCliente());
        ListaLivrosResponse response = listaLivrosMapper.toListaLivrosResponse(novaLista);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ListaLivrosResponse>> listarListas() {
        try {
            List<ListaLivrosEntity> listas = listaLivrosUseCase.listarListas();
            List<ListaLivrosResponse> response = listas.stream()
                    .map(listaLivrosMapper::toListaLivrosResponse)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<ListaLivrosResponse>> listarListasPorCliente(@PathVariable Long clienteId) {
        List<ListaLivrosEntity> listas = listaLivrosUseCase.listarListasPorCliente(clienteId);
        List<ListaLivrosResponse> response = listas.stream()
                .map(listaLivrosMapper::toListaLivrosResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{listaId}/adicionarLivro")
    public ResponseEntity<ListaLivrosResponse> adicionarLivroALista(@PathVariable Long listaId, @RequestBody BookIdRequest request) {
        ListaLivrosEntity lista = listaLivrosUseCase.buscarListaPorId(listaId);

        if (lista == null) {
            return ResponseEntity.notFound().build();
        }

        String bookId = request.getBookId();
        BookItemEntity livro = livroUseCase.searchBookById(bookId);

        if (livro == null) {
            return ResponseEntity.notFound().build();
        }

        if (livroJaEstaNaLista(lista, livro)) {
            return ResponseEntity.badRequest().build();
        }

        BookItemEntity novoLivro = new BookItemEntity();
        novoLivro.setVolumeInfo(livro.getVolumeInfo());
        novoLivro.setLista(lista);
        lista.getItems().add(novoLivro);

        var listaResponse = listaLivrosMapper.toListaLivrosResponse(lista);
        var listaEntity = listaLivrosUseCase.salvarLista(listaResponse);

        return ResponseEntity.ok(listaResponse);

    }

    private boolean livroJaEstaNaLista(ListaLivrosEntity lista, BookItemEntity livro) {
        for (BookItemEntity item : lista.getItems()) {
            if (item.getId().equals(livro.getId())) {
                return true;
            }
        }
        return false;
    }
}



