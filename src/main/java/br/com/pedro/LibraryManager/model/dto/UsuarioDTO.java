package br.com.pedro.LibraryManager.model.dto;

public class UsuarioDTO {
    private String email;
    private String nome;
    private String senha;
    private String nascimento;
    private Long id;
    private String rua;
    private String numero;
    private String cidade;

    public UsuarioDTO(String email, String nome, String senha, String nascimento, Long id, String rua, String numero, String cidade) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.nascimento = nascimento;
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
