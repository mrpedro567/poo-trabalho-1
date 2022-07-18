package com.pedro.model.dados;

import java.util.Calendar;
import java.util.List;

public class Emprestimo {
	private Cliente cliente;
	private List<Livro> livros;
	private Boolean concluido;
	private Calendar dataRetorno;
	private Float multaDia;
	
	public Emprestimo() {
		
	}
	
	public Emprestimo(Cliente cliente, List<Livro> livros, Boolean concluido, Calendar dataRetorno, Float multaDia) {
		this.cliente = cliente;
		this.livros = livros;
		this.concluido = concluido;
		this.dataRetorno = dataRetorno;
		this.multaDia = multaDia;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Livro> getLivros() {
		return livros;
	}
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	public Boolean getConcluido() {
		return concluido;
	}
	public void setConcluido(Boolean concluido) {
		this.concluido = concluido;
	}
	public Calendar getDataRetorno() {
		return dataRetorno;
	}
	public void setDataRetorno(Calendar dataRetorno) {
		this.dataRetorno = dataRetorno;
	}
	public Float getMultaDia() {
		return multaDia;
	}
	public void setMultaDia(Float multaDia) {
		this.multaDia = multaDia;
	}
}
