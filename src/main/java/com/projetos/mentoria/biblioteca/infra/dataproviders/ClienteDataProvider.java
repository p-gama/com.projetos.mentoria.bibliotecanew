package com.projetos.mentoria.biblioteca.infra.dataproviders;

import com.projetos.mentoria.biblioteca.domain.entities.ClienteEntity;
import com.projetos.mentoria.biblioteca.domain.entities.EnderecoEntity;
import com.projetos.mentoria.biblioteca.infra.dataproviders.mapper.ClienteEntityMapper;
import com.projetos.mentoria.biblioteca.infra.dataproviders.mapper.EnderecoEntityMapper;
import com.projetos.mentoria.biblioteca.infra.repository.entities.Cliente;
import com.projetos.mentoria.biblioteca.infra.repository.entities.Endereco;
import com.projetos.mentoria.biblioteca.domain.gateways.ClienteGateway;
import com.projetos.mentoria.biblioteca.infra.clients.CepServiceClient;
import com.projetos.mentoria.biblioteca.infra.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ClienteDataProvider implements ClienteGateway {
    private final ClienteRepository clienteRepository;
    private final ClienteEntityMapper clienteEntityMapper;

    @Autowired
    public ClienteDataProvider(ClienteRepository clienteRepository, ClienteEntityMapper clienteEntityMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteEntityMapper = clienteEntityMapper;
    }

    @Override
    public ClienteEntity salvarClienteComEndereco(ClienteEntity cliente) {
        Cliente clienteToSave = clienteEntityMapper.toCliente(cliente);
        Cliente savedCliente = clienteRepository.save(clienteToSave);
        return clienteEntityMapper.toClienteEntity(savedCliente);
    }

    @Override
    public List<ClienteEntity> listarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(clienteEntityMapper::toClienteEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ClienteEntity> findById(Long clienteId) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(clienteId);
        return clienteOptional.map(clienteEntityMapper::toClienteEntity);
    }
}
//@Component
//public class ClienteDataProvider implements ClienteGateway {
//    @Autowired
//    private ClienteRepository clienteRepository;
//
//    private ClienteEntityMapper clienteEntityMapper;
//    private EnderecoEntityMapper enderecoEntityMapper
//
//    @Autowired
//    private CepServiceClient cepServiceClient; //ALTERAR
//
//    @Override
//    public ClienteEntity salvarClienteComEndereco(ClienteEntity cliente) {
//        for (EnderecoEntity endereco : cliente.getEnderecos()) {
//            endereco.setCliente(cliente);
//
//            EnderecoEntity viaCepEndereco = enderecoEntityMapper.toEnderecoEntity((cepServiceClient.consultarCep(endereco.getCep())));
//
//            if (viaCepEndereco != null) {
//                endereco.setLogradouro(viaCepEndereco.getLogradouro());
//                endereco.setComplemento(viaCepEndereco.getComplemento());
//                endereco.setBairro(viaCepEndereco.getBairro());
//                endereco.setLocalidade(viaCepEndereco.getLocalidade());
//                endereco.setUf(viaCepEndereco.getUf());
//            }
//        }
//
//        return clienteEntityMapper.toClienteEntity(clienteRepository.save(cliente));
//    }
//
//    @Override
//    public List<ClienteEntity> listarClientes() {
//        return clienteRepository.findAll();
//    }
//
//    @Override
//    public Optional<ClienteEntity> findById(Cliente cliente){
//        return clienteRepository.findById(cliente.getIdPessoa());
//    }
//}
