package com.planosaudeapi.controller;

import com.planosaudeapi.dto.AutorizacaoRequestDTO;
import com.planosaudeapi.dto.AutorizacaoResponseDTO;
import com.planosaudeapi.service.AutorizacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Autorizacao", description = "Gerenciamento de autorizacaos")
@RestController
@RequestMapping("/api/autorizacaos")
public class AutorizacaoController {

    @Autowired
    private AutorizacaoService service;

    @Operation(summary = "Listar todos os Autorizacao")
    @GetMapping
    public List<AutorizacaoResponseDTO> listar(@RequestParam(required = false) String procedimento, @RequestParam(required = false) Long beneficiarioId, @RequestParam(required = false) Long prestadorId) {
        List<AutorizacaoResponseDTO> resultado = service.listar();
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

    @Operation(summary = "Buscar Autorizacao por ID")
    @GetMapping("/{id}")
    public AutorizacaoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Autorizacao")
    @PostMapping
    public ResponseEntity<AutorizacaoResponseDTO> criar(@Valid @RequestBody AutorizacaoRequestDTO autorizacao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(autorizacao));
    }

    @Operation(summary = "Atualizar Autorizacao")
    @PutMapping("/{id}")
    public AutorizacaoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody AutorizacaoRequestDTO autorizacao) {
        return service.atualizar(id, autorizacao);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Autorizacao")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
