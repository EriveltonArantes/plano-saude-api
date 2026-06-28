package com.planosaudeapi.service;

import com.planosaudeapi.dto.BeneficiarioRequestDTO;
import com.planosaudeapi.dto.BeneficiarioResponseDTO;
import com.planosaudeapi.exception.ResourceNotFoundException;
import com.planosaudeapi.mapper.BeneficiarioMapper;
import com.planosaudeapi.model.Beneficiario;
import com.planosaudeapi.repository.BeneficiarioRepository;
import com.planosaudeapi.repository.PrestadorRepository;
import com.planosaudeapi.model.Prestador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BeneficiarioService {

    @Autowired
    private BeneficiarioRepository repository;

    @Autowired
    private BeneficiarioMapper mapper;

    @Autowired
    private PrestadorRepository prestadorRepository;

    @Transactional(readOnly = true)
    public List<BeneficiarioResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BeneficiarioResponseDTO buscar(Long id) {
        Beneficiario entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Beneficiario não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public BeneficiarioResponseDTO criar(BeneficiarioRequestDTO dto) {
        Beneficiario entity = mapper.toEntity(dto);
        Prestador prestador = prestadorRepository.findById(dto.getPrestadorId())
            .orElseThrow(() -> new ResourceNotFoundException("Prestador não encontrado com id: " + dto.getPrestadorId()));
        entity.setPrestador(prestador);
        Beneficiario salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public BeneficiarioResponseDTO atualizar(Long id, BeneficiarioRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Beneficiario não encontrado com id: " + id);
        }
        Beneficiario entity = mapper.toEntity(dto);
        entity.setId(id);
        Prestador prestador = prestadorRepository.findById(dto.getPrestadorId())
            .orElseThrow(() -> new ResourceNotFoundException("Prestador não encontrado com id: " + dto.getPrestadorId()));
        entity.setPrestador(prestador);
        Beneficiario salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Beneficiario não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
