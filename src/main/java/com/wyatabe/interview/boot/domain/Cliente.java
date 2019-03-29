package com.wyatabe.interview.boot.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Classe que representa o cliente.")
@SuppressWarnings("serial")
@Entity
@Table(name = "tb_cliente")
public class Cliente extends AbstractEntity<Long> {
	
	@ApiModelProperty(value = "Nome Completo", example = "Fulano de Tal", required = true, position = 1)
	@Column(name = "nome_completo", nullable = false)
	private String nomeCompleto;
	
	@ApiModelProperty(value = "Sexo", example = "M", required = true, position = 2)
	@Column(nullable = false, length = 1)
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@ApiModelProperty(value = "Data de Nascimento", example = "1985-12-07", required = true, position = 3)
	@Column(name = "data_nascimento", nullable = false, columnDefinition = "DATE")
	private LocalDate dataNascimento;
	
	@ApiModelProperty(value = "Idade", example = "33", required = true, position = 4)
	@Column(nullable = false, length = 3)
	private Integer idade;
	
	@ApiModelProperty(value = "Cidade", example = "{id: 1}", required = true, position = 5)
	@ManyToOne
	@JoinColumn(name = "cidade_id_fk")
	private Cidade cidade;

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
}