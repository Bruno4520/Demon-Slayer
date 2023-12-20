package br.edu.unifei.demon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public abstract class Local implements Serializable{
	private static final long serialVersionUID = -2352052862901766721L;
	@Id private String nome;
	private int concentracaoEspiritual;
	@OneToMany(cascade = CascadeType.REMOVE) private List<Ser> habitantes = new ArrayList<Ser>();
	@ManyToOne(cascade = CascadeType.REMOVE) private Universo mundoPertencente;
	
	public Local(Universo mundoPertencente) {
		this.mundoPertencente = mundoPertencente;
	}
	
	public Local() {}
	
	private void calculaConcentracao() {
		concentracaoEspiritual = 0;
		for(Ser elem : habitantes) {
			concentracaoEspiritual += elem.getReiatsu();
		}
	}
	
	public int getConcentracaoEspiritual() {
		calculaConcentracao();
		return concentracaoEspiritual;
	}
}
