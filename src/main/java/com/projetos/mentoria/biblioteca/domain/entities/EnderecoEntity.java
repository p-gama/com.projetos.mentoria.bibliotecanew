package com.projetos.mentoria.biblioteca.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.projetos.mentoria.biblioteca.infra.repository.entities.Cliente;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class EnderecoEntity {

    private Integer idEnderecoCliente;

    private String cep;
    private String logradouro;
    private String complemento;
    private String complementoEndereco;
    private String bairro;
    private String localidade;
    private String uf;
    @JsonIgnore
    private ClienteEntity cliente;
}