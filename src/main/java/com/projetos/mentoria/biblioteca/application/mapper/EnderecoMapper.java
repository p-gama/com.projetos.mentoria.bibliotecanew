package com.projetos.mentoria.biblioteca.application.mapper;

import com.projetos.mentoria.biblioteca.application.model.EnderecoResponse;
import com.projetos.mentoria.biblioteca.domain.entities.EnderecoEntity;
import com.projetos.mentoria.biblioteca.infra.repository.entities.Endereco;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    EnderecoEntity toEnderecoEntity (EnderecoResponse enderecoResponse);

    EnderecoResponse toEnderecoResponse (EnderecoEntity endereco);

}
