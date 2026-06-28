package com.planosaudeapi.dto;

import jakarta.validation.constraints.*;

public class BeneficiarioRequestDTO {

    @NotNull(message = "PrestadorId é obrigatório")
    @Positive(message = "PrestadorId deve ser um ID válido (positivo)")
    private Long prestadorId;
    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "cpf não pode estar em branco")
    @Size(min = 11, max = 14, message = "cpf deve ter entre 11 e 14 dígitos")
    private String cpf;
    @NotBlank(message = "email não pode estar em branco")
    @Email(message = "email precisa ser um e-mail válido")
    private String email;
    @NotBlank(message = "telefone não pode estar em branco")
    private String telefone;
    @NotNull(message = "data nascimento não pode ser nulo")
    private java.time.LocalDateTime dataNascimento;
    @NotBlank(message = "plano não pode estar em branco")
    private String plano;
    @NotNull(message = "titular não pode ser nulo")
    private Boolean titular;
    @NotNull(message = "data adesao não pode ser nulo")
    private java.time.LocalDateTime dataAdesao;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

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
