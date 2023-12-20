package br.edu.unifei.demon;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class Espadachim extends Raca {
	private static final long serialVersionUID = -1602614291683679863L;
	private boolean possuiBankai;
	private int afinidadeZanpakuto;
	private String fraseDeEfeito;
	
	@Override
	public void transformacao(Ser ser, Raca raca) {
		if(raca instanceof Demonio) {
			if(ser.isMorto()) {
				ser.setRaca(raca);
			}
		}else {
			ser.setRaca(raca);
		}
		
	}
	
	public void liberarArmamento(Ser s, Armamento a) {
		if(afinidadeZanpakuto>=100) {
			s.getEspada().liberar(s, a);
		}
	}
	
	/*public void ceifar(Ser ser, Local local) {
		if((ser.getRaca() instanceof Alma)&&
				(ser.getLocalAtual().getMundoPertencente() instanceof MundoFisico)) {
			ser.setLocalAtual(local);
		}
	}*/
}
