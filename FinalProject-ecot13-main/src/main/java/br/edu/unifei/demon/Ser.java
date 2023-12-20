package br.edu.unifei.demon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Ser implements Serializable{
	private static final long serialVersionUID = 5007343646506341727L;
	@Id private String nome;
	private int reiatsu;
	private boolean morto = false;
	@ManyToOne private Organizacao organizacao;
	@OneToOne private Raca raca;
	@ManyToOne private Local localAtual;
	@OneToOne private Armamento espada;
	@ManyToMany private List<Habilidade> habilidades = new ArrayList<Habilidade>();
	
	public Ser(Raca raca) {
		this.raca = raca;
	}
	
	public Ser() {}
	
	public void transformar(Raca novaRaca) {
		raca.transformacao(this, novaRaca);
	}

	public void setEspada(Armamento espada) {
		if(raca instanceof Espadachim) {
			this.espada = espada;
		}
		if(espada==null) {
			this.espada = espada;
		}else if((raca instanceof Demonio) && (espada.getTipo() == ArmType.ZANPAKUTO)) {
			this.espada = espada;
		}
	}
}
