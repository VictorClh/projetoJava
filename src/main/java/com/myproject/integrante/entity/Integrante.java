package com.myproject.integrante.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Integrante")
public class Integrante {

	@Id
	private String cpf;
	private String nome;
	private String projeto;
	private String dataNasc;
	@Column(name="phone")
	private String fone;

	public Integrante() {

	}

	public Integrante(String cpf, String nome, String projeto, String dataNasc, String fone) {
		this.cpf = cpf;
		this.nome = nome;
		this.fone = fone;
		this.projeto = projeto;
		this.dataNasc = dataNasc;
	}

	public String getProjeto() {
		return projeto;
	}

	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
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
