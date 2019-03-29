package com.wyatabe.interview.boot.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Classe que representa a cidade.")
@SuppressWarnings("serial")
@Entity
@Table(name="tb_cidade")
public class Cidade extends AbstractEntity<Long> {

	@ApiModelProperty(notes = "Nome da Cidade", example = "São Paulo", required = true, position = 1)
	@Column(nullable = false, unique = true, length = 100)
	private String nome;
	
	@ApiModelProperty(notes = "Estado", example = "SP", required = true, position = 2)
	@Column(nullable = false, length = 2)
	@Enumerated(EnumType.STRING)
	private Estado estado;
	
	@ApiModelProperty(notes = "Lista de Clientes", required = false,  hidden = true)
	@OneToMany(mappedBy = "cidade", cascade = CascadeType.ALL)
	private List<Cliente> clientes;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
}