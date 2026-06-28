package com.planosaudeapi.mapper;

import com.planosaudeapi.dto.PrestadorRequestDTO;
import com.planosaudeapi.dto.PrestadorResponseDTO;
import com.planosaudeapi.model.Prestador;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PrestadorMapper {

    Prestador toEntity(PrestadorRequestDTO dto);

    PrestadorResponseDTO toResponseDTO(Prestador entity);
}
