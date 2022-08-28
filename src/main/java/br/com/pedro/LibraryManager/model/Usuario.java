package br.com.pedro.LibraryManager.model;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
public class Usuario {
    @Id
    @NotNull
    private String email;


    @NotNull
    private String nome;
    @NotNull
    private String senha;
    @NotNull
    private LocalDate nascimento;

    private String rua;
    private String numero;
    private String cidade;

    public Usuario() {
    }

    public Usuario(String email, String nome, String senha, LocalDate nascimento, String rua, String numero, String cidade) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.nascimento = nascimento;
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

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return email.equals(usuario.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
