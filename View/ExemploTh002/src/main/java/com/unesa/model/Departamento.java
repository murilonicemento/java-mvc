package com.unesa.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Departamento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idDepto;
	private String nome;
	
	@OneToMany(mappedBy="departamento")
    private Set<Funcionario> funcionarios;
	
	public Departamento() {}
	
	public Integer getIdDepto() {
		return idDepto;
	}
	
	public void setIdDepto(Integer idDepto) {
		this.idDepto = idDepto;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
