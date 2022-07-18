package com.pedro.model.dados;

import java.util.Calendar;
import java.util.List;


public class Cliente extends Pessoa{
	private String endereco;
	private Calendar nascimento;
	private List<Emprestimo> emprestimo;
	
	public Cliente() {
		super();
	}
	
	public Cliente(String nome, String endereco, Calendar nascimento, List<Emprestimo> emprestimo) {
		super(nome);
		this.endereco = endereco;
		this.nascimento = nascimento;
		this.emprestimo = emprestimo;
	}
	
	public Cliente(String nome) {
		super(nome);
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
