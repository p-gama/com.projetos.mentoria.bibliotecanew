package com.projetos.mentoria.biblioteca.infra.dataproviders;

import com.projetos.mentoria.biblioteca.domain.entities.EnderecoEntity;
import com.projetos.mentoria.biblioteca.domain.exception.NaoEncontradoException;
import com.projetos.mentoria.biblioteca.domain.gateways.EnderecoGateway;
import com.projetos.mentoria.biblioteca.infra.clients.CepServiceClient;
import com.projetos.mentoria.biblioteca.infra.dataproviders.mapper.EnderecoEntityMapper;
import com.projetos.mentoria.biblioteca.infra.repository.EnderecoRepository;
import com.projetos.mentoria.biblioteca.infra.repository.entities.Cliente;
import com.projetos.mentoria.biblioteca.infra.repository.entities.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnderecoDataProvider implements EnderecoGateway {
    private final EnderecoRepository enderecoRepository;
    private final CepServiceClient cepServiceClient;
    private final EnderecoEntityMapper enderecoEntityMapper;

    @Autowired
    public EnderecoDataProvider(EnderecoRepository enderecoRepository, CepServiceClient cepServiceClient, EnderecoEntityMapper enderecoEntityMapper) {
        this.enderecoRepository = enderecoRepository;
        this.cepServiceClient = cepServiceClient;
        this.enderecoEntityMapper = enderecoEntityMapper;
    }

    @Override
    public EnderecoEntity cadastrarEndereco(String cep) {
        EnderecoEntity endereco = cepServiceClient.consultarCep(cep);

        if (endereco != null) {
            Endereco enderecoConsultado = enderecoEntityMapper.toEndereco(endereco);
            Endereco enderecoSalvo = enderecoRepository.save(enderecoConsultado);
            return enderecoEntityMapper.toEnderecoEntity(enderecoSalvo);
        } else {
            throw new NaoEncontradoException("CEP não encontrado");
        }
    }
}
