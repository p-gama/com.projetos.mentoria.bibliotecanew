package com.projetos.mentoria.biblioteca.domain.entities;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.projetos.mentoria.biblioteca.infra.repository.entities.BookItem;
import com.projetos.mentoria.biblioteca.infra.repository.entities.Cliente;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class ListaLivrosEntity {

    private Long idLista;

    private Cliente cliente;


    private String nomeLista;

    private List<BookItemEntity> items;

}