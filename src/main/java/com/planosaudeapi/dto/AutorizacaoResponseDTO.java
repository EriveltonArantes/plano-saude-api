package com.planosaudeapi.dto;

public class AutorizacaoResponseDTO {

    private Long id;
    private Long beneficiarioId;
    private Long prestadorId;
    private String procedimento;
    private java.time.LocalDateTime datasolicitacao;
    private java.time.LocalDateTime dataAutorizacao;
    private java.time.LocalDateTime validade;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
