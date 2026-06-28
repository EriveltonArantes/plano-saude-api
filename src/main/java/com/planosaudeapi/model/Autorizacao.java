package com.planosaudeapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "autorizacoes")
public class Autorizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "beneficiario_id")
    private Beneficiario beneficiario;
    @ManyToOne
    @JoinColumn(name = "prestador_id")
    private Prestador prestador;
    @Column(nullable = false)
    private String procedimento;
    private java.time.LocalDateTime datasolicitacao;
    private java.time.LocalDateTime dataAutorizacao;
    private java.time.LocalDateTime validade;
    @Column(nullable = false)
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Beneficiario getBeneficiario() { return beneficiario; }
    public void setBeneficiario(Beneficiario beneficiario) { this.beneficiario = beneficiario; }
    public Prestador getPrestador() { return prestador; }
    public void setPrestador(Prestador prestador) { this.prestador = prestador; }
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
