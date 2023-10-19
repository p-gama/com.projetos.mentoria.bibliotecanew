package com.projetos.mentoria.biblioteca.infra.dataproviders.mapper;

import com.projetos.mentoria.biblioteca.domain.entities.ClienteEntity;
import com.projetos.mentoria.biblioteca.infra.repository.entities.Cliente;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClienteEntityMapper {

    ClienteEntity toClienteEntity (Cliente cliente);

    Cliente toCliente (ClienteEntity cliente);

    @AfterMapping
    default void toClienteAfterMapping(ClienteEntity entity, @MappingTarget Cliente target) {
        if (target != null) {
            // Evite recursão infinita
            target.setEnderecos(null);
        }
    }

    @AfterMapping
    default void toClienteEntityAfterMapping(Cliente dto, @MappingTarget ClienteEntity target) {
        if (target != null) {
            // Evite recursão infinita
            target.setEnderecos(null);
        }
    }


}
