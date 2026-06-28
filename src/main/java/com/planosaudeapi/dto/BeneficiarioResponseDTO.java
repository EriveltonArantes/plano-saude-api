package com.planosaudeapi.dto;

public class BeneficiarioResponseDTO {

    private Long id;
    private Long prestadorId;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private java.time.LocalDateTime dataNascimento;
    private String plano;
    private Boolean titular;
    private java.time.LocalDateTime dataAdesao;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getPrestadorId() { return prestadorId; }
    public void setPrestadorId(Long prestadorId) { this.prestadorId = prestadorId; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public java.time.LocalDateTime getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(java.time.LocalDateTime dataNascimento) { this.dataNascimento = dataNascimento; }
    public String getPlano() { return plano; }
    public void setPlano(String plano) { this.plano = plano; }
    public Boolean getTitular() { return titular; }
    public void setTitular(Boolean titular) { this.titular = titular; }
    public java.time.LocalDateTime getDataAdesao() { return dataAdesao; }
    public void setDataAdesao(java.time.LocalDateTime dataAdesao) { this.dataAdesao = dataAdesao; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
