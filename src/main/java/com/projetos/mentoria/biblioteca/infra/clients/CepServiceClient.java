package com.projetos.mentoria.biblioteca.infra.clients;

import com.projetos.mentoria.biblioteca.domain.entities.EnderecoEntity;
import com.projetos.mentoria.biblioteca.infra.repository.entities.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface CepServiceClient {

    @GetMapping("/{cep}/json/")
    EnderecoEntity consultarCep(@PathVariable("cep") String cep);
}