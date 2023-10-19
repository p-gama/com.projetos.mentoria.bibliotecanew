package com.projetos.mentoria.biblioteca.domain.gateways;

import com.projetos.mentoria.biblioteca.domain.entities.ClienteEntity;
import com.projetos.mentoria.biblioteca.infra.repository.entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteGateway {
    ClienteEntity salvarClienteComEndereco(ClienteEntity cliente);
    List<ClienteEntity> listarClientes();
    Optional<ClienteEntity> findById(Long clienteId);
}
