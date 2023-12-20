package br.edu.unifei.demon;

import javax.persistence.Entity;
import javax.persistence.Enumerated;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class Lua extends Raca{
	private static final long serialVersionUID = 6311755660631084878L;
	private int hollowsDevorados;
	private int almasDevoradas;
	@Enumerated private EnumHollow tipo = EnumHollow.ADJUNCHA;
	
	@Override
	public void transformacao(Ser s, Raca r) {}
}
