package com.projetos.mentoria.biblioteca.application.usecases;

import com.projetos.mentoria.biblioteca.domain.entities.EnderecoEntity;

public interface EnderecoUseCase {

    EnderecoEntity cadastrarEndereco(String cep);
}
