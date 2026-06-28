package com.planosaudeapi.repository;

import com.planosaudeapi.model.Utilizacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilizacaoRepository extends JpaRepository<Utilizacao, Long> {
}
