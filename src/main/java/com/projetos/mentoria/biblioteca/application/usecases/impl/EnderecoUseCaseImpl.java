package com.projetos.mentoria.biblioteca.application.usecases.impl;

import com.projetos.mentoria.biblioteca.application.usecases.EnderecoUseCase;
import com.projetos.mentoria.biblioteca.domain.entities.EnderecoEntity;
import com.projetos.mentoria.biblioteca.domain.gateways.EnderecoGateway;
import org.springframework.stereotype.Component;

@Component
public class EnderecoUseCaseImpl implements EnderecoUseCase {
    private final EnderecoGateway enderecoGateway;

    public EnderecoUseCaseImpl(EnderecoGateway enderecoGateway) {
        this.enderecoGateway = enderecoGateway;
    }


    @Override
    public EnderecoEntity cadastrarEndereco(String cep) {
        return enderecoGateway.cadastrarEndereco(cep);
    }
}