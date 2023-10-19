package com.projetos.mentoria.biblioteca.infra.dataproviders.mapper;

import com.projetos.mentoria.biblioteca.application.model.EnderecoResponse;
import com.projetos.mentoria.biblioteca.domain.entities.EnderecoEntity;
import com.projetos.mentoria.biblioteca.infra.repository.entities.Endereco;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoEntityMapper {

    EnderecoEntity toEnderecoEntity (Endereco endereco);

    Endereco toEndereco (EnderecoEntity enderecoEntity);

}
