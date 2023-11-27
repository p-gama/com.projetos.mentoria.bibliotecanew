package com.projetos.mentoria.biblioteca.infra.dataproviders.mapper;

import com.projetos.mentoria.biblioteca.domain.entities.VolumeInfoEntity;
import com.projetos.mentoria.biblioteca.infra.repository.entities.VolumeInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VolumeInfoEntityMapper {
    VolumeInfoEntity toVolumeInfoEntity (VolumeInfo volumeInfo);
    VolumeInfo toVolumeInfo (VolumeInfoEntity volumeInfoEntity);
}
