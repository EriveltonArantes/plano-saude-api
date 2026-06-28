package com.planosaudeapi.dto;

public class UtilizacaoResponseDTO {

    private Long id;
    private Long beneficiarioId;
    private Long prestadorId;
    private String procedimento;
    private java.time.LocalDateTime dataRealizacao;
    private Double valorCobrado;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
