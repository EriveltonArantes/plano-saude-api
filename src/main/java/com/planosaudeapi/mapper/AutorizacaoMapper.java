package com.planosaudeapi.mapper;

import com.planosaudeapi.dto.AutorizacaoRequestDTO;
import com.planosaudeapi.dto.AutorizacaoResponseDTO;
import com.planosaudeapi.model.Autorizacao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AutorizacaoMapper {

    @Mapping(target = "beneficiario", ignore = true)
    @Mapping(target = "prestador", ignore = true)
    Autorizacao toEntity(AutorizacaoRequestDTO dto);

    @Mapping(target = "beneficiarioId", source = "beneficiario.id")
    @Mapping(target = "prestadorId", source = "prestador.id")
    AutorizacaoResponseDTO toResponseDTO(Autorizacao entity);
}
