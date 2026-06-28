package com.planosaudeapi.controller;

import com.planosaudeapi.model.Beneficiario;
import com.planosaudeapi.model.Prestador;
import com.planosaudeapi.model.Autorizacao;
import com.planosaudeapi.model.Utilizacao;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Tag(name = "Dashboard", description = "KPIs e totais do sistema")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private com.planosaudeapi.repository.BeneficiarioRepository beneficiarioRepository;

    @Autowired
    private com.planosaudeapi.repository.PrestadorRepository prestadorRepository;

    @Autowired
    private com.planosaudeapi.repository.AutorizacaoRepository autorizacaoRepository;

    @Autowired
    private com.planosaudeapi.repository.UtilizacaoRepository utilizacaoRepository;

    @Operation(summary = "Resumo com totais, somas e gráficos de status")
    @Transactional(readOnly = true)
    @GetMapping("/resumo")
    public Map<String, Object> resumo() {
        Map<String, Object> resumo = new LinkedHashMap<>();
        resumo.put("totalBeneficiario", beneficiarioRepository.count());
        resumo.put("graficoBeneficiario", beneficiarioRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalPrestador", prestadorRepository.count());
        resumo.put("totalAutorizacao", autorizacaoRepository.count());
        resumo.put("graficoAutorizacao", autorizacaoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalUtilizacao", utilizacaoRepository.count());
        resumo.put("somaValorCobradoUtilizacao", utilizacaoRepository.findAll().stream().filter(e -> e.getValorCobrado() != null).mapToDouble(e -> e.getValorCobrado()).sum());
        resumo.put("graficoUtilizacao", utilizacaoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        return resumo;
    }
}
