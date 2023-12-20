package br.edu.unifei.demon;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class Cidade extends Local {
	private static final long serialVersionUID = 5393135506496999803L;
	private int quantidadePessoas;
	private int tamanho;
	
	public Cidade(String nome, Universo mundoPertencente) {
		super(mundoPertencente);
		this.setNome(nome);
	}
	
	public Cidade() {}
	
	public void calculaQuantidadePessoas() {
		quantidadePessoas = this.getHabitantes().size();
	}
	
	//private void setQuantidadedePessoas(int q) {}
}
