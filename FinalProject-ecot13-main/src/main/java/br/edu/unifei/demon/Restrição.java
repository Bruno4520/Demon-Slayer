package br.edu.unifei.demon;

import javax.persistence.Entity;
import javax.persistence.Enumerated;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class Restrição extends Raca{
	private static final long serialVersionUID = 2596751027948489172L;
	private int hollowsDevorados;
	private int almasDevoradas;
	@Enumerated private EnumHollow tipo = EnumHollow.COMUM;
	
	public boolean evolucao() {
		if(tipo == EnumHollow.COMUM) {
			if(almasDevoradas+hollowsDevorados>50) {
				tipo = EnumHollow.GILLIAN;
				return true;
			}
		}else if(tipo == EnumHollow.GILLIAN) {
			if(hollowsDevorados>75) {
				tipo = EnumHollow.ADJUNCHA;
				return true;
			}
		}else if(tipo == EnumHollow.ADJUNCHA) {
			if(hollowsDevorados>100) {
				tipo = EnumHollow.VASTOLORD;
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void transformacao(Ser s, Raca r) {
		if(r instanceof Demonio) {
			s.setRaca(r);
		}
	}	
}

