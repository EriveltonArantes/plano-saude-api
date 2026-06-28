package com.planosaudeapi.dto;

import jakarta.validation.constraints.*;

public class UtilizacaoRequestDTO {

    @NotNull(message = "BeneficiarioId é obrigatório")
    @Positive(message = "BeneficiarioId deve ser um ID válido (positivo)")
    private Long beneficiarioId;
    @NotNull(message = "PrestadorId é obrigatório")
    @Positive(message = "PrestadorId deve ser um ID válido (positivo)")
    private Long prestadorId;
    @NotBlank(message = "procedimento não pode estar em branco")
    private String procedimento;
    @NotNull(message = "data realizacao não pode ser nulo")
    private java.time.LocalDateTime dataRealizacao;
    @DecimalMin(value = "0.0", message = "valor cobrado não pode ser negativo")
    @NotNull(message = "valor cobrado não pode ser nulo")
    private Double valorCobrado;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

    public Long getBeneficiarioId() { return beneficiarioId; }
    public void setBeneficiarioId(Long beneficiarioId) { this.beneficiarioId = beneficiarioId; }
    public Long getPrestadorId() { return prestadorId; }
    public void setPrestadorId(Long prestadorId) { this.prestadorId = prestadorId; }
    public String getProcedimento() { return procedimento; }
    public void setProcedimento(String procedimento) { this.procedimento = procedimento; }
    public java.time.LocalDateTime getDataRealizacao() { return dataRealizacao; }
    public void setDataRealizacao(java.time.LocalDateTime dataRealizacao) { this.dataRealizacao = dataRealizacao; }
    public Double getValorCobrado() { return valorCobrado; }
    public void setValorCobrado(Double valorCobrado) { this.valorCobrado = valorCobrado; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
