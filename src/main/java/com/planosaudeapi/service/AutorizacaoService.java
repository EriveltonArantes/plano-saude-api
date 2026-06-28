package com.planosaudeapi.service;

import com.planosaudeapi.dto.AutorizacaoRequestDTO;
import com.planosaudeapi.dto.AutorizacaoResponseDTO;
import com.planosaudeapi.exception.ResourceNotFoundException;
import com.planosaudeapi.mapper.AutorizacaoMapper;
import com.planosaudeapi.model.Autorizacao;
import com.planosaudeapi.repository.AutorizacaoRepository;
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
public class AutorizacaoService {

    @Autowired
    private AutorizacaoRepository repository;

    @Autowired
    private AutorizacaoMapper mapper;

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    @Autowired
    private PrestadorRepository prestadorRepository;

    @Transactional(readOnly = true)
    public List<AutorizacaoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AutorizacaoResponseDTO buscar(Long id) {
        Autorizacao entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Autorizacao não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public AutorizacaoResponseDTO criar(AutorizacaoRequestDTO dto) {
        Autorizacao entity = mapper.toEntity(dto);
        Beneficiario beneficiario = beneficiarioRepository.findById(dto.getBeneficiarioId())
            .orElseThrow(() -> new ResourceNotFoundException("Beneficiario não encontrado com id: " + dto.getBeneficiarioId()));
        entity.setBeneficiario(beneficiario);
        Prestador prestador = prestadorRepository.findById(dto.getPrestadorId())
            .orElseThrow(() -> new ResourceNotFoundException("Prestador não encontrado com id: " + dto.getPrestadorId()));
        entity.setPrestador(prestador);
        Autorizacao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public AutorizacaoResponseDTO atualizar(Long id, AutorizacaoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Autorizacao não encontrado com id: " + id);
        }
        Autorizacao entity = mapper.toEntity(dto);
        entity.setId(id);
        Beneficiario beneficiario = beneficiarioRepository.findById(dto.getBeneficiarioId())
            .orElseThrow(() -> new ResourceNotFoundException("Beneficiario não encontrado com id: " + dto.getBeneficiarioId()));
        entity.setBeneficiario(beneficiario);
        Prestador prestador = prestadorRepository.findById(dto.getPrestadorId())
            .orElseThrow(() -> new ResourceNotFoundException("Prestador não encontrado com id: " + dto.getPrestadorId()));
        entity.setPrestador(prestador);
        Autorizacao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Autorizacao não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
