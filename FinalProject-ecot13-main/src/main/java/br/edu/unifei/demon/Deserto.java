package br.edu.unifei.demon;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class Deserto extends Local {
	private static final long serialVersionUID = 9057257153944348958L;
	private int temperatura=40;
	
	public Deserto(Universo mundoPertencente) {
		super(mundoPertencente);
	}
	
	public Deserto() {}
}
