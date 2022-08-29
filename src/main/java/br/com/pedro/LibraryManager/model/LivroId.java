package br.com.pedro.LibraryManager.model;

import com.sun.istack.NotNull;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

public class LivroId implements Serializable {
    private String titulo;

    private String edicao;

    public LivroId(String titulo, String edicao) {
        this.titulo = titulo;
        this.edicao = edicao;
    }

    public LivroId(){}

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LivroId livroId = (LivroId) o;
        return titulo.equals(livroId.titulo) && edicao.equals(livroId.edicao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, edicao);
    }
}
