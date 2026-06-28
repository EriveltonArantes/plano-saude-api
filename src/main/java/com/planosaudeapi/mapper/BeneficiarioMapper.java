package com.planosaudeapi.mapper;

import com.planosaudeapi.dto.BeneficiarioRequestDTO;
import com.planosaudeapi.dto.BeneficiarioResponseDTO;
import com.planosaudeapi.model.Beneficiario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BeneficiarioMapper {

    @Mapping(target = "prestador", ignore = true)
    Beneficiario toEntity(BeneficiarioRequestDTO dto);

    @Mapping(target = "prestadorId", source = "prestador.id")
    BeneficiarioResponseDTO toResponseDTO(Beneficiario entity);
}
