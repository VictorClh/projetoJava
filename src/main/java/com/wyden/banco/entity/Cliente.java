package com.wyden.banco.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {

	@Id
	private String cpf;
	private String nome;
	@Column(name="phone")
	private String fone;

	public Cliente() {

	}

	public Cliente(String cpf, String nome, String fone) {
		this.cpf = cpf;
		this.nome = nome;
		this.fone = fone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

}
