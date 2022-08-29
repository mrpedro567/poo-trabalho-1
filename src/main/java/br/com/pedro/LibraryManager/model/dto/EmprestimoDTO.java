package br.com.pedro.LibraryManager.model.dto;

import br.com.pedro.LibraryManager.model.Livro;
import br.com.pedro.LibraryManager.model.Usuario;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class EmprestimoDTO {

    private LocalDate dataLocacao;
    private LocalDate dataDevolucao;
    private LocalDateTime dataConclusao;
    private Float multa;
    private String titulo;
    private String edicao;
    private String usuario;

    public EmprestimoDTO() {
    }

    public EmprestimoDTO(LocalDate dataLocacao, LocalDate dataDevolucao, LocalDateTime dataConclusao, Float multa, String titulo, String edicao, String usuario) {
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
        this.dataConclusao = dataConclusao;
        this.multa = multa;
        this.titulo = titulo;
        this.edicao = edicao;
        this.usuario = usuario;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
