package br.edu.unifei.demon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Organizacao {
	@Id private String nome;
	private String regras;
	private String inimigos;
	@OneToMany private List<Ser> membros = new ArrayList<Ser>();
	@OneToMany private List<Organizacao> gruposInternos = new ArrayList<Organizacao>();
	
	public void adicionarLider(Ser ser) {
		Collections.reverse(membros);
		membros.add(ser);
		Collections.reverse(membros);
	}
	
	public void adicionarMembro(Ser ser) {
		membros.add(ser);
	}
	
	//quanto menor o indice, mais alto o posto
	public boolean alterarPosto(Ser ser, int posto) {
		if(membros.contains(ser)) {
			int aux = membros.indexOf(ser);
			Ser auxiliar = membros.get(posto);
			membros.set(posto, ser);
			membros.set(aux, auxiliar);
			return true;
		}
		return false;
	}
	
	public boolean removerMembro(Ser ser) {
		return membros.remove(ser);
	}
}
