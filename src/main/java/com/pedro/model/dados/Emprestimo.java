package com.pedro.model.dados;

import java.util.Calendar;
import java.util.List;

public class Emprestimo {
	private Usuario usuario;
	private Livro livro;
	private Boolean concluido;
	private Calendar dataRetorno;
	private Float multaDia;
	
	public Emprestimo() {
		
	}
	
	public Emprestimo(Cliente cliente, Livro livro, Boolean concluido, Calendar dataRetorno, Float multaDia) {
		this.usuario = cliente;
		this.livro = livro;
		this.concluido = concluido;
		this.dataRetorno = dataRetorno;
		this.multaDia = multaDia;
	}
	
	public Cliente getCliente() {
		return usuario;
	}
	public void setCliente(Cliente cliente) {
		this.usuario = cliente;
	}
	public Livro getLivro() {
		return this.livro;
	}
	public void setLivro(Livr livro {
		this.livro = livro;
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
		return this.multaDia;
	}
	public void setMultaDia(Float multaDia) {
		this.multaDia = multaDia;
	}
}
