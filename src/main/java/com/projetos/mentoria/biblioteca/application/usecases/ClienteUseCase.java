package com.projetos.mentoria.biblioteca.application.usecases;

import com.projetos.mentoria.biblioteca.application.model.ClienteDTO;
import com.projetos.mentoria.biblioteca.domain.entities.ClienteEntity;

import java.util.List;
import java.util.Optional;
public interface ClienteUseCase {
    ClienteEntity salvarClienteComEndereco(ClienteDTO request);
    List<ClienteEntity> listarClientes();
    Optional<ClienteEntity> findById(Long clienteId);
}