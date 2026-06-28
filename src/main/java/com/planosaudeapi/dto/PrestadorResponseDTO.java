package com.planosaudeapi.dto;

public class PrestadorResponseDTO {

    private Long id;
    private String nome;
    private String crm;
    private String especialidade;
    private String email;
    private String telefone;
    private Boolean credenciado;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCrm() { return crm; }
    public void setCrm(String crm) { this.crm = crm; }
    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public Boolean getCredenciado() { return credenciado; }
    public void setCredenciado(Boolean credenciado) { this.credenciado = credenciado; }
}
