package br.com.pedro.LibraryManager.model;

import com.sun.istack.NotNull;

import javax.annotation.Generated;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @NotNull
    private LocalDate dataLocacao;

    @NotNull
    private LocalDate dataDevolucao;

    @NotNull
    private LocalDateTime dataConclusao;

    @NotNull
    private Float multa;

    @OneToOne
    @JoinColumns({
            @JoinColumn(name="titulo", referencedColumnName = "titulo"),
            @JoinColumn(name="edicao", referencedColumnName = "edicao")
    })
    @NotNull
    private Livro livro;

    @OneToOne
    @JoinColumn(name = "email")
    @NotNull
    private Usuario usuario;

    public Emprestimo() {
    }

    public Emprestimo(LocalDate dataLocacao, LocalDate dataDevolucao, LocalDateTime dataConclusao, Float multa, Livro livro, Usuario usuario) {

        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
        this.dataConclusao = dataConclusao;
        this.multa = multa;
        this.livro = livro;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(LocalDate dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public Float getMulta() {
        return multa;
    }

    public void setMulta(Float multa) {
        this.multa = multa;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emprestimo that = (Emprestimo) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
