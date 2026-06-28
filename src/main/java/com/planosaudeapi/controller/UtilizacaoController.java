package com.planosaudeapi.controller;

import com.planosaudeapi.dto.UtilizacaoRequestDTO;
import com.planosaudeapi.dto.UtilizacaoResponseDTO;
import com.planosaudeapi.service.UtilizacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Utilizacao", description = "Gerenciamento de utilizacaos")
@RestController
@RequestMapping("/api/utilizacaos")
public class UtilizacaoController {

    @Autowired
    private UtilizacaoService service;

    @Operation(summary = "Listar todos os Utilizacao")
    @GetMapping
    public List<UtilizacaoResponseDTO> listar(@RequestParam(required = false) String procedimento, @RequestParam(required = false) Long beneficiarioId, @RequestParam(required = false) Long prestadorId) {
        List<UtilizacaoResponseDTO> resultado = service.listar();
        if (procedimento != null && !procedimento.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getProcedimento() != null &&
                item.getProcedimento().toLowerCase().contains(procedimento.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (beneficiarioId != null) {
            resultado = resultado.stream().filter(item -> beneficiarioId.equals(item.getBeneficiarioId())).collect(java.util.stream.Collectors.toList());
        }
        if (prestadorId != null) {
            resultado = resultado.stream().filter(item -> prestadorId.equals(item.getPrestadorId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Utilizacao por ID")
    @GetMapping("/{id}")
    public UtilizacaoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Utilizacao")
    @PostMapping
    public ResponseEntity<UtilizacaoResponseDTO> criar(@Valid @RequestBody UtilizacaoRequestDTO utilizacao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(utilizacao));
    }

    @Operation(summary = "Atualizar Utilizacao")
    @PutMapping("/{id}")
    public UtilizacaoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody UtilizacaoRequestDTO utilizacao) {
        return service.atualizar(id, utilizacao);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Utilizacao")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
