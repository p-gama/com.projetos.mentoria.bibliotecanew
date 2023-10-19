package com.projetos.mentoria.biblioteca.api.controller;

import com.projetos.mentoria.biblioteca.application.model.EnderecoResponse;
import com.projetos.mentoria.biblioteca.application.usecases.EnderecoUseCase;
import com.projetos.mentoria.biblioteca.domain.entities.EnderecoEntity;
import com.projetos.mentoria.biblioteca.infra.repository.entities.Endereco;
import com.projetos.mentoria.biblioteca.infra.clients.CepServiceClient;
import com.projetos.mentoria.biblioteca.application.mapper.EnderecoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnderecoController {

    @Autowired
    private final CepServiceClient cepServiceClient;

    private final EnderecoUseCase enderecoUseCase;

    private final EnderecoMapper mapper;

    public EnderecoController(CepServiceClient cepServiceClient, EnderecoUseCase enderecoUseCase, EnderecoMapper mapper) {
        this.cepServiceClient = cepServiceClient;
        this.enderecoUseCase = enderecoUseCase;
        this.mapper = mapper;
    }

    @GetMapping("/buscarcep/{cep}")
    public ResponseEntity<EnderecoResponse> getCep(@PathVariable String cep) {

        EnderecoEntity endereco = cepServiceClient.consultarCep(cep);

        return endereco != null ? ResponseEntity.ok().body(mapper.toEnderecoResponse(endereco)) : ResponseEntity.notFound().build();
    }

}