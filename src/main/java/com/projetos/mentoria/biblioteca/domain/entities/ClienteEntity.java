package com.projetos.mentoria.biblioteca.domain.entities;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.projetos.mentoria.biblioteca.infra.repository.entities.Endereco;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ClienteEntity {


    private Long idPessoa;

    private String nome;
    private Integer idade;
    private String cpf;
    private String email;

    private List<EnderecoEntity> enderecos = new ArrayList<>();
}