package com.projetos.mentoria.biblioteca.application.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.projetos.mentoria.biblioteca.infra.repository.entities.BookItem;
import com.projetos.mentoria.biblioteca.infra.repository.entities.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ListaLivrosResponse {

    private Long idLista;

    private Cliente cliente;

    private String nomeLista;

    private List<BookItemResponse> items;
}
