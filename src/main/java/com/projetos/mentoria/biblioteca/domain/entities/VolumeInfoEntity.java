package com.projetos.mentoria.biblioteca.domain.entities;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VolumeInfoEntity {

    private String title;

    private String[] authors;

    private String description;

}