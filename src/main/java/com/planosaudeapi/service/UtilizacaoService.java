package com.planosaudeapi.service;

import com.planosaudeapi.dto.UtilizacaoRequestDTO;
import com.planosaudeapi.dto.UtilizacaoResponseDTO;
import com.planosaudeapi.exception.ResourceNotFoundException;
import com.planosaudeapi.mapper.UtilizacaoMapper;
import com.planosaudeapi.model.Utilizacao;
import com.planosaudeapi.repository.UtilizacaoRepository;
import com.planosaudeapi.repository.BeneficiarioRepository;
import com.planosaudeapi.model.Beneficiario;
import com.planosaudeapi.repository.PrestadorRepository;
import com.planosaudeapi.model.Prestador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UtilizacaoService {

    @Autowired
    private UtilizacaoRepository repository;

    @Autowired
    private UtilizacaoMapper mapper;

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    @Autowired
    private PrestadorRepository prestadorRepository;

    @Transactional(readOnly = true)
    public List<UtilizacaoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UtilizacaoResponseDTO buscar(Long id) {
        Utilizacao entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Utilizacao não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public UtilizacaoResponseDTO criar(UtilizacaoRequestDTO dto) {
        Utilizacao entity = mapper.toEntity(dto);
        Beneficiario beneficiario = beneficiarioRepository.findById(dto.getBeneficiarioId())
            .orElseThrow(() -> new ResourceNotFoundException("Beneficiario não encontrado com id: " + dto.getBeneficiarioId()));
        entity.setBeneficiario(beneficiario);
        Prestador prestador = prestadorRepository.findById(dto.getPrestadorId())
            .orElseThrow(() -> new ResourceNotFoundException("Prestador não encontrado com id: " + dto.getPrestadorId()));
        entity.setPrestador(prestador);
        Utilizacao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public UtilizacaoResponseDTO atualizar(Long id, UtilizacaoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Utilizacao não encontrado com id: " + id);
        }
        Utilizacao entity = mapper.toEntity(dto);
        entity.setId(id);
        Beneficiario beneficiario = beneficiarioRepository.findById(dto.getBeneficiarioId())
            .orElseThrow(() -> new ResourceNotFoundException("Beneficiario não encontrado com id: " + dto.getBeneficiarioId()));
        entity.setBeneficiario(beneficiario);
        Prestador prestador = prestadorRepository.findById(dto.getPrestadorId())
            .orElseThrow(() -> new ResourceNotFoundException("Prestador não encontrado com id: " + dto.getPrestadorId()));
        entity.setPrestador(prestador);
        Utilizacao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Utilizacao não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
