package br.com.htex.model;

import java.math.BigDecimal;

public class Quarto {
	private int id;
	private int numero;
	private BigDecimal precoDiaria;
	private boolean disponivel;
	private int hotelId;

	public Quarto(int id, int numero, BigDecimal precoDiaria, boolean disponivel, int hotelId) {
		this.id = id;
		this.numero = numero;
		this.precoDiaria = precoDiaria;
		this.disponivel = true;
		this.hotelId = hotelId;
	}
	
	public int getId() {
		return id;
	}
 
	public int getNumero() {
		return numero;
	}

	public BigDecimal getPrecoDiaria() {
		return precoDiaria;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public int getHotelId() {
		return hotelId;
	}

	@Override
	public String toString() {
		return "Quarto [id=" + id + ", numero=" + numero + ", precoDiaria=" + precoDiaria + ", disponivel=" + disponivel
				+ ", hotelId=" + hotelId + "]";
	}
	

}
