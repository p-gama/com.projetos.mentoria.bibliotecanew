package com.projetos.mentoria.biblioteca.application.usecases.impl;

import com.projetos.mentoria.biblioteca.application.mapper.ClienteMapper;
import com.projetos.mentoria.biblioteca.application.model.ClienteDTO;
import com.projetos.mentoria.biblioteca.application.usecases.ClienteUseCase;
import com.projetos.mentoria.biblioteca.domain.entities.ClienteEntity;
import com.projetos.mentoria.biblioteca.domain.gateways.ClienteGateway;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClienteUseCaseImpl implements ClienteUseCase {
    private final ClienteGateway clienteGateway;
    private final ClienteMapper clienteMapper;

    public ClienteUseCaseImpl(ClienteGateway clienteGateway, ClienteMapper clienteMapper) {
        this.clienteGateway = clienteGateway;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public ClienteEntity salvarClienteComEndereco(ClienteDTO cliente) {
        ClienteEntity clienteEntity = clienteMapper.toEntity(cliente);
        return clienteGateway.salvarClienteComEndereco(clienteEntity);
    }
    @Override
    public List<ClienteEntity> listarClientes() {
        return clienteGateway.listarClientes();
    }

    @Override
    public Optional<ClienteEntity> findById(Long clienteId) {
        return clienteGateway.findById(clienteId);
    }
}

//@Component
//public class ClienteUseCaseImpl implements ClienteUseCase {
//    private final ClienteGateway clienteGateway;
//
//    private final ClienteMapper clienteMapper;
//
//    public ClienteUseCaseImpl(ClienteGateway clienteGateway) {
//        this.clienteGateway = clienteGateway;
//    }
//
//
//    @Override
//    public ClienteEntity salvarClienteComEndereco(Cliente cliente) {
//        return clienteMapper.to(clienteGateway.salvarClienteComEndereco(cliente));
//    }
//
//    @Override
//    public List<Cliente> listarClientes() {
//
//        return clienteGateway.listarClientes();
//    }
//
//    @Override
//    public Optional<ClienteDTO> findById(Cliente cliente) {
//        return clienteGateway.findById(cliente);
//    }
//}