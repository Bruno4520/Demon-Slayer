package br.edu.unifei.demon;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class Alma extends Raca {
	private static final long serialVersionUID = 3750748700839709911L;
	private boolean ceifado;
	private int tempoDeMorte;
	private String profissao;
	
	@Override
	public void transformacao(Ser ser, Raca raca) {
		ser.setRaca(raca);
	}
}
