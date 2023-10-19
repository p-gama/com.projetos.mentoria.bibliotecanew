package com.projetos.mentoria.biblioteca.domain.gateways;

import com.projetos.mentoria.biblioteca.domain.entities.EnderecoEntity;

public interface EnderecoGateway {
    EnderecoEntity cadastrarEndereco(String cep);
}
