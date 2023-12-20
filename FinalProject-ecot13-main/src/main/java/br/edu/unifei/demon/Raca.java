package br.edu.unifei.demon;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public abstract class Raca implements Serializable{
	private static final long serialVersionUID = -773351432093172869L;
	@Id @GeneratedValue private int id;
	private int vida=100;
	private int defesa=20;
	private int forca=15;
	private int velocidade=20;
	private int reservaEspiritual=100;
	
	public abstract void transformacao(Ser ser, Raca raca);
}
