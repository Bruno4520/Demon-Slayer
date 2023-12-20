package br.edu.unifei.demon;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Universo implements Serializable{
	private static final long serialVersionUID = -2138440509878392683L;
	private String titulos;
	private int energiaTotal;
	private int quantidadeHabitantes;
	@Id @Enumerated(EnumType.STRING) private WorldType tipo;
	@OneToMany private List<Local> locais = new ArrayList<Local>();
	
	public Universo(WorldType tipo) {
		this.tipo = tipo;
	}
	
	public Universo() {}
	
	public void caculaEnergiaTotal() {
		energiaTotal = 0;
		for(Local elem: locais) {
			energiaTotal += elem.getConcentracaoEspiritual();
		}
	}
	
	public void calculaQuantidadeHabitantes() {
		quantidadeHabitantes = 0;
		for(Local l : locais) {
			quantidadeHabitantes += l.getHabitantes().size();
		}
	}
	
	//Fenda não pode estar na listas
	public void addLocal(Local local) {
		if(!(local instanceof Fenda)) {
			locais.add(local);
		}
	}
}
