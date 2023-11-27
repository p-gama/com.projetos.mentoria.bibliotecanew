package com.projetos.mentoria.biblioteca.application.mapper;

import com.projetos.mentoria.biblioteca.application.model.VolumeInfoResponse;
import com.projetos.mentoria.biblioteca.domain.entities.VolumeInfoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VolumeInfoMapper {

    VolumeInfoEntity toVolumeInfoEntity (VolumeInfoResponse volumeInfoResponse);

    VolumeInfoResponse toVolumeInfoResponse (VolumeInfoEntity volumeInfo);

}