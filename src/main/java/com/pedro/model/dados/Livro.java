package com.pedro.model.dados;

public class Livro {
	private String nome;
	private Pessoa autor;
	private String edicao;
	private Editora editora;
	
	public Livro() {
	
	}

	public Livro(String nome, Pessoa autor, String edicao, Editora editora) {
		this.nome = nome;
		this.autor = autor;
		this.edicao = edicao;
		this.editora = editora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pessoa getAutor() {
		return autor;
	}

	public void setAutor(Pessoa autor) {
		this.autor = autor;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	
}
