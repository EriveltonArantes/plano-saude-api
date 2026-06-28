package com.planosaudeapi.mapper;

import com.planosaudeapi.dto.UtilizacaoRequestDTO;
import com.planosaudeapi.dto.UtilizacaoResponseDTO;
import com.planosaudeapi.model.Utilizacao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UtilizacaoMapper {

    @Mapping(target = "beneficiario", ignore = true)
    @Mapping(target = "prestador", ignore = true)
    Utilizacao toEntity(UtilizacaoRequestDTO dto);

    @Mapping(target = "beneficiarioId", source = "beneficiario.id")
    @Mapping(target = "prestadorId", source = "prestador.id")
    UtilizacaoResponseDTO toResponseDTO(Utilizacao entity);
}
