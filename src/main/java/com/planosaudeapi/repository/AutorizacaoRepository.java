package com.planosaudeapi.repository;

import com.planosaudeapi.model.Autorizacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorizacaoRepository extends JpaRepository<Autorizacao, Long> {
}
