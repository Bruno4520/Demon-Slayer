package br.edu.unifei.demon;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Armamento implements Serializable{
	private static final long serialVersionUID = -3804651452013751257L;
	
	private int resistencia;
	private int forcaExtra;
	@Id private String nome;
	private String descricao;
	@ManyToMany private List<Habilidade> habilidade = new ArrayList<Habilidade>();
	@Enumerated private ArmType tipo;
	private boolean quebrado;
	
	
	public Armamento() {}
	public Armamento(String nome, ArmType tipo) {
		this.nome = nome;
		this.tipo = tipo;
		Habilidade especial = new Habilidade();
		this.habilidade.add(especial);
	}
	
	public void liberar(Ser s, Armamento a) {
		s.setEspada(a);
	}
	
	public Habilidade especial() {
		return habilidade.get(0);
	}
}
