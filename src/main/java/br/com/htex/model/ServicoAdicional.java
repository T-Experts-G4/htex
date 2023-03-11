package br.com.htex.model;

import java.math.BigDecimal;

public class ServicoAdicional {
	private int id;
	private String nome;
	private String descricao;
	private BigDecimal preco;
	
	public ServicoAdicional() {	}

	public ServicoAdicional(int id, String nome, String descricao, BigDecimal preco) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	public ServicoAdicional(String nome, String descricao, BigDecimal preco) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}
	
}
