package br.com.projetoSenac.domain;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;

@Entity
public class Carro implements Serializable{

	private static final long serialVersionUID = 6357248956064063817L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Integer id;
	private String nome;
	private String marca;
	private Integer ano;
	
	public Integer getId() {
		return id;
		
	}
	
	public void setId(Integer id) {
		this.id = id;
		
	}
	
	public String getNome() {
		return nome;
		
	}
	
	public void setNome(String nome) {
		this.nome = nome;
		
	}
	
	public String getMarca() {
		return marca;
		
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
		
	}
	
	public Integer getAno() {
		return ano;
		
	}
	
	public void setAno(Integer ano) {
		this.ano = ano;
		
	}


}
