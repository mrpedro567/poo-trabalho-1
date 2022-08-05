package com.pedro.model.dados;

import java.util.Calendar;
import java.util.List;


public class Usuario extends Pessoa{
	private String endereco;
	private Calendar nascimento;
	private List<Emprestimo> emprestimo;
	private String email;
	private String senha;
	
	public Usuario() {
		super();
	}
	
	public Usuario(String nome, String endereco, Calendar nascimento, List<Emprestimo> emprestimo, String email, String senha) {
		super(nome);
		this.endereco = endereco;
		this.nascimento = nascimento;
		this.emprestimo = emprestimo;
		this.email = email;
		this.senha = senha;
	}

	public Usuario(String nome) {
		super(nome);
	}

	public java.lang.String getEmail() {
		return email;
	}

	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	public java.lang.String getSenha() {
		return senha;
	}

	public void setSenha(java.lang.String senha) {
		this.senha = senha;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Calendar getNascimento() {
		return nascimento;
	}
	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}
	public List<Emprestimo> getEmprestimo() {
		return emprestimo;
	}
	public void setEmprestimo(List<Emprestimo> emprestimo) {
		this.emprestimo = emprestimo;
	}
}
