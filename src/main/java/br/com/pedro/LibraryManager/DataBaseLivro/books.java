package br.com.pedro.LibraryManager.DataBaseLivro;

import javax.persistence.*;

@Entity
@Table(name = "LivrosDataBase")

public class books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String edicao;
    private String autor;
    private Integer editora;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getEditora() {
        return editora;
    }

    public void setEditora(Integer editora) {
        this.editora = editora;
    }

}
