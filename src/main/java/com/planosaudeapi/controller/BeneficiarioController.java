package com.planosaudeapi.controller;

import com.planosaudeapi.dto.BeneficiarioRequestDTO;
import com.planosaudeapi.dto.BeneficiarioResponseDTO;
import com.planosaudeapi.service.BeneficiarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Beneficiario", description = "Gerenciamento de beneficiarios")
@RestController
@RequestMapping("/api/beneficiarios")
public class BeneficiarioController {

    @Autowired
    private BeneficiarioService service;

    @Operation(summary = "Listar todos os Beneficiario")
    @GetMapping
    public List<BeneficiarioResponseDTO> listar(@RequestParam(required = false) String nome, @RequestParam(required = false) Long prestadorId) {
        List<BeneficiarioResponseDTO> resultado = service.listar();
        if (nome != null && !nome.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNome() != null &&
                item.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (prestadorId != null) {
            resultado = resultado.stream().filter(item -> prestadorId.equals(item.getPrestadorId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Beneficiario por ID")
    @GetMapping("/{id}")
    public BeneficiarioResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Beneficiario")
    @PostMapping
    public ResponseEntity<BeneficiarioResponseDTO> criar(@Valid @RequestBody BeneficiarioRequestDTO beneficiario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(beneficiario));
    }

    @Operation(summary = "Atualizar Beneficiario")
    @PutMapping("/{id}")
    public BeneficiarioResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody BeneficiarioRequestDTO beneficiario) {
        return service.atualizar(id, beneficiario);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Beneficiario")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
