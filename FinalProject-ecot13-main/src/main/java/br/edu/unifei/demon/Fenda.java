package br.edu.unifei.demon;

import java.util.List;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class Fenda extends Local {
	private static final long serialVersionUID = 3441996595348707513L;
	private int tempoAberta;
	
	public Fenda(Universo mundoDePartida) {
		super(mundoDePartida);
	}
	
	public Fenda() {}
	
	public boolean abertura(Ser ser, Local novoLocal) {
		if(tempoAberta<1)
			return false;
	
		ser.getRaca().setReservaEspiritual(ser.getRaca().getReservaEspiritual()-10-(int)(tempoAberta*0.5));
		transportar(this.getHabitantes(), novoLocal);
		return true;
	}
	
	private void transportar(List<Ser> seres, Local destino) {
		for(Ser s : seres) {
			s.getLocalAtual().getHabitantes().remove(s);
			s.setLocalAtual(destino);
			destino.getHabitantes().add(s);
			
		}
	}
}
