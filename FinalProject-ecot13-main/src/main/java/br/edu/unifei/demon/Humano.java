package br.edu.unifei.demon;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class Humano extends Raca {
	private static final long serialVersionUID = 690693734120538618L;
	private boolean quincy;
	private String profissao;
	private boolean percepcaoEspiritual;
	
	public void virarQuincy() {
		if(percepcaoEspiritual) {
			quincy = true;
		}else{
			System.out.println("O humano deve poder ver espritos\n");
		}
	}
	@Override
	public void transformacao(Ser s, Raca r){
		if(!(r instanceof Demonio)) {
			s.setRaca(r);
		}
	}

}
