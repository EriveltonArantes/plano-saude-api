package com.planosaudeapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "utilizacoes")
public class Utilizacao {

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
    private java.time.LocalDateTime dataRealizacao;
    private Double valorCobrado;
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
    public java.time.LocalDateTime getDataRealizacao() { return dataRealizacao; }
    public void setDataRealizacao(java.time.LocalDateTime dataRealizacao) { this.dataRealizacao = dataRealizacao; }
    public Double getValorCobrado() { return valorCobrado; }
    public void setValorCobrado(Double valorCobrado) { this.valorCobrado = valorCobrado; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
