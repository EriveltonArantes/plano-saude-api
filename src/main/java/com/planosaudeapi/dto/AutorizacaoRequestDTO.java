package com.planosaudeapi.dto;

import jakarta.validation.constraints.*;

public class AutorizacaoRequestDTO {

    @NotNull(message = "BeneficiarioId é obrigatório")
    @Positive(message = "BeneficiarioId deve ser um ID válido (positivo)")
    private Long beneficiarioId;
    @NotNull(message = "PrestadorId é obrigatório")
    @Positive(message = "PrestadorId deve ser um ID válido (positivo)")
    private Long prestadorId;
    @NotBlank(message = "procedimento não pode estar em branco")
    private String procedimento;
    @NotNull(message = "datasolicitacao não pode ser nulo")
    private java.time.LocalDateTime datasolicitacao;
    @NotNull(message = "data autorizacao não pode ser nulo")
    private java.time.LocalDateTime dataAutorizacao;
    @NotNull(message = "validade não pode ser nulo")
    private java.time.LocalDateTime validade;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

    public Long getBeneficiarioId() { return beneficiarioId; }
    public void setBeneficiarioId(Long beneficiarioId) { this.beneficiarioId = beneficiarioId; }
    public Long getPrestadorId() { return prestadorId; }
    public void setPrestadorId(Long prestadorId) { this.prestadorId = prestadorId; }
    public String getProcedimento() { return procedimento; }
    public void setProcedimento(String procedimento) { this.procedimento = procedimento; }
    public java.time.LocalDateTime getDatasolicitacao() { return datasolicitacao; }
    public void setDatasolicitacao(java.time.LocalDateTime datasolicitacao) { this.datasolicitacao = datasolicitacao; }
    public java.time.LocalDateTime getDataAutorizacao() { return dataAutorizacao; }
    public void setDataAutorizacao(java.time.LocalDateTime dataAutorizacao) { this.dataAutorizacao = dataAutorizacao; }
    public java.time.LocalDateTime getValidade() { return validade; }
    public void setValidade(java.time.LocalDateTime validade) { this.validade = validade; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
