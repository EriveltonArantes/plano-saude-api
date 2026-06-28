package com.planosaudeapi.controller;

import com.planosaudeapi.dto.PrestadorRequestDTO;
import com.planosaudeapi.dto.PrestadorResponseDTO;
import com.planosaudeapi.service.PrestadorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Prestador", description = "Gerenciamento de prestadors")
@RestController
@RequestMapping("/api/prestadors")
public class PrestadorController {

    @Autowired
    private PrestadorService service;

    @Operation(summary = "Listar todos os Prestador")
    @GetMapping
    public List<PrestadorResponseDTO> listar(@RequestParam(required = false) String nome) {
        List<PrestadorResponseDTO> resultado = service.listar();
        if (nome != null && !nome.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNome() != null &&
                item.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Prestador por ID")
    @GetMapping("/{id}")
    public PrestadorResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Prestador")
    @PostMapping
    public ResponseEntity<PrestadorResponseDTO> criar(@Valid @RequestBody PrestadorRequestDTO prestador) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(prestador));
    }

    @Operation(summary = "Atualizar Prestador")
    @PutMapping("/{id}")
    public PrestadorResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody PrestadorRequestDTO prestador) {
        return service.atualizar(id, prestador);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Prestador")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
