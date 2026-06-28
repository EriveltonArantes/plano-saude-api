package com.planosaudeapi.service;

import com.planosaudeapi.dto.PrestadorRequestDTO;
import com.planosaudeapi.dto.PrestadorResponseDTO;
import com.planosaudeapi.exception.ResourceNotFoundException;
import com.planosaudeapi.mapper.PrestadorMapper;
import com.planosaudeapi.model.Prestador;
import com.planosaudeapi.repository.PrestadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PrestadorService {

    @Autowired
    private PrestadorRepository repository;

    @Autowired
    private PrestadorMapper mapper;

    @Transactional(readOnly = true)
    public List<PrestadorResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PrestadorResponseDTO buscar(Long id) {
        Prestador entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Prestador não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public PrestadorResponseDTO criar(PrestadorRequestDTO dto) {
        Prestador entity = mapper.toEntity(dto);
        Prestador salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public PrestadorResponseDTO atualizar(Long id, PrestadorRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Prestador não encontrado com id: " + id);
        }
        Prestador entity = mapper.toEntity(dto);
        entity.setId(id);
        Prestador salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Prestador não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
