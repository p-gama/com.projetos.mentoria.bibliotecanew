package com.projetos.mentoria.biblioteca.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projetos.mentoria.biblioteca.infra.repository.entities.ListaLivros;
import com.projetos.mentoria.biblioteca.infra.repository.entities.VolumeInfo;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookItemEntity {

    private String id;

    private VolumeInfoEntity volumeInfo;

    @JsonIgnore
    private ListaLivrosEntity lista;

}