package model.entities;

import model.exceptions.DomainException;

public class Account {
	private Integer numero;
	private String nome;
	private Double saldo;
	private Double limiteSaque;
	
	public Account() {
	}

	public Account(Integer numero, String nome, Double saldo, Double limiteSaque) {
		this.numero = numero;
		this.nome = nome;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getLimiteSaque() {
		return limiteSaque;
	}

	public void setLimiteSaque(Double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}

	public Double getSaldo() {
		return saldo;
	}
	
	public void deposito(Double valor) {
		saldo += valor;
	}
	
	public void saque(Double valor) {
		if (valor > limiteSaque) {
			throw new DomainException("Valor superior ao limite de saque");
		}
		
		if (saldo < valor) {
			throw new DomainException("Saldo insuficiente");
		}
		
		saldo -= valor;
	}
}
