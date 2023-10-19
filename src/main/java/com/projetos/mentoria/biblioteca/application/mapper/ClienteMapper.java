package com.projetos.mentoria.biblioteca.application.mapper;

import com.projetos.mentoria.biblioteca.application.model.ClienteDTO;
import com.projetos.mentoria.biblioteca.domain.entities.ClienteEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteDTO toClienteDTO(ClienteEntity cliente);
    ClienteEntity toEntity(ClienteDTO clienteDTO);
}

