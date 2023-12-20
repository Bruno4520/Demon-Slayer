package br.edu.unifei.demon;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Habilidade implements Serializable{
	private static final long serialVersionUID = -5424675661004299570L;
	@Id private String nome;
	private int gasto;
	private int efeito;
	private String descricao;
	@Enumerated private EnumHabilidade tipo = EnumHabilidade.DANO;
	
	public boolean usarHabilidadeControlada(Ser alvo, Ser usuario, int energia) {
		usuario.getRaca().setReservaEspiritual(usuario.getRaca().getReservaEspiritual()-gasto-energia);
		if(tipo == EnumHabilidade.DANO) {
			if(usuario.getRaca().getForca()>alvo.getRaca().getDefesa()) {
				alvo.getRaca().setVida(alvo.getRaca().getDefesa()-(int)(efeito*energia/3));
				alvo.getRaca().setDefesa(alvo.getRaca().getDefesa()-(int)(efeito*energia/4));
				return true;
			}
		}else if (tipo == EnumHabilidade.CURA) {
			if(alvo.getRaca().getVida()>0) {
				alvo.getRaca().setVida(alvo.getRaca().getVida()+(int)(efeito*energia/2));
				return true;
			}
		}else if(tipo == EnumHabilidade.DEFESA) {
			alvo.getRaca().setDefesa(alvo.getRaca().getDefesa()+(int)(efeito*energia/2));
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}
