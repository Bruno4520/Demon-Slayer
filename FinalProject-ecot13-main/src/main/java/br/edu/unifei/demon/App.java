
package br.edu.unifei.demon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

	public static void main(String[] args) {
		//criação dos mundos
		EntityManagerFactory emf
        = Persistence.createEntityManagerFactory("bleach");
		EntityManager em = emf.createEntityManager();
		
		Universo mundoHumano = new Universo(WorldType.MUNDO_FISICO);
		Universo mundoDasAlmas = new Universo(WorldType.SOUL_SOCYETY);
		Universo mundoAssombroso = new Universo(WorldType.HUECO_MUNDO);
		
		//criação dos locais principais
		Local cidadePrincipal = new Cidade("Dazaifu",mundoHumano);
		mundoHumano.addLocal(cidadePrincipal);
		
		Local Beppu = new Cidade("Beppu",mundoDasAlmas);
		Local cidadeDasAlmas = new Cidade("Yagyu",mundoDasAlmas);
		mundoDasAlmas.addLocal(cidadeDasAlmas);
		mundoDasAlmas.addLocal(Beppu);
		
		Local lasNotches = new Cidade("Okutama",mundoAssombroso);
		Local deserto = new Deserto(mundoAssombroso);
		deserto.setNome("Deserto Fundo");
		mundoAssombroso.addLocal(lasNotches);
		mundoAssombroso.addLocal(deserto);
		
		//criando organizacao principal
		Organizacao primeira = new Organizacao();
		primeira.setNome("Primeiros Hashiras");
		primeira.setRegras("Manter a ordem");
		
		Organizacao decimaPrimeira = new Organizacao();
		decimaPrimeira.setNome("Hashiras de reinan");
		decimaPrimeira.setRegras("Lutar sem depender dos outros");
		decimaPrimeira.setInimigos("Qualquer um que seja forte");
		
		Organizacao sexta = new Organizacao();
		sexta.setNome("Sub Hashiras");
		sexta.setRegras("Resiliencia");
		
		Organizacao hashiras = new Organizacao();
		hashiras.setNome("Hashiras");
		hashiras.setRegras("Manter o equilibrio do mundo");
		hashiras.setInimigos("Demonios");
		hashiras.getGruposInternos().add(primeira);
		hashiras.getGruposInternos().add(sexta);
		hashiras.getGruposInternos().add(decimaPrimeira);

//-------------------------primeiro persist-------------------------------------
//		em.getTransaction().begin();
//		em.persist(cidadePrincipal);
//		em.persist(Beppu);
//		em.persist(cidadeDasAlmas);
//		em.persist(lasNotches);
//		em.persist(deserto);
//		
//		em.persist(mundoHumano);
//		em.persist(mundoDasAlmas);
//		em.persist(mundoAssombroso);
//		em.getTransaction().commit();
//		
//		em.getTransaction().begin();
//		em.persist(primeira);
//		em.persist(decimaPrimeira);
//		em.persist(sexta);
//		em.persist(hashiras);
//		em.getTransaction().commit();
//----------------------------------------------------------------------------
		//criando ataque basico
		Habilidade aa = new Habilidade();
		aa.setDescricao("Ataque normal utilizando a arma que tem\nCaso nao haja arma usa os punhos");
		aa.setEfeito(2);
		aa.setGasto(0);
		aa.setNome("Ataque basico");
		aa.setTipo(EnumHabilidade.DANO);

		//criando personagens
		Espadachim shiP = new Espadachim();
		Ser protagonista = new Ser(shiP);
		protagonista.setLocalAtual(cidadePrincipal);
		protagonista.setNome("Tajiro");
		protagonista.setReiatsu(5);
		protagonista.setOrganizacao(hashiras);
		cidadePrincipal.getHabitantes().add(protagonista);
		protagonista.setEspada(new Armamento("Respiracao do Sol",ArmType.SHINKAI));
		protagonista.getEspada().getHabilidade().set(0, aa);
		protagonista.getHabilidades().add(aa);

		Espadachim cap1 = new Espadachim();
		Ser hashira1 = new Ser(cap1);
		hashira1.setNome("Yoriichi");
		hashira1.setLocalAtual(Beppu);
		hashira1.getRaca().setReservaEspiritual(500);
		hashira1.setReiatsu(35);
		hashira1.setOrganizacao(primeira);
		hashira1.setEspada(new Armamento("Respiracao solar",ArmType.SHINKAI));
		hashira1.getEspada().getHabilidade().set(0, aa);

		Espadachim cap2 = new Espadachim();
		Ser hashira2 = new Ser(cap2);
		hashira2.setNome("Sanemi");
		hashira2.setLocalAtual(Beppu);
		hashira2.getRaca().setReservaEspiritual(500);
		hashira2.setReiatsu(50);
		hashira2.setOrganizacao(decimaPrimeira);
		hashira2.setEspada(new Armamento("Ventaval",ArmType.ZANPAKUTO));
		hashira2.getEspada().getHabilidade().set(0, aa);
		
		Espadachim cap3 = new Espadachim();
		Ser hashira3 = new Ser(cap3);
		hashira3.setNome("Gyomei");
		hashira3.setLocalAtual(Beppu);
		hashira3.setReiatsu(10);
		hashira3.setOrganizacao(sexta);
		hashira3.setEspada(new Armamento("Pedra",ArmType.SHINKAI));
		hashira3.getEspada().getHabilidade().set(0, aa);
		
		Beppu.getHabitantes().add(hashira3);
		Beppu.getHabitantes().add(hashira2);
		Beppu.getHabitantes().add(hashira1);
		
		primeira.getMembros().add(hashira1);
		sexta.getMembros().add(hashira2);
		decimaPrimeira.getMembros().add(hashira3);
		hashiras.getMembros().add(protagonista);
		
		Humano u = new Humano();
		Ser uryu = new Ser(u);
		uryu.setNome("Kazumi");
		uryu.setReiatsu(2);
		uryu.setLocalAtual(cidadePrincipal);
		cidadePrincipal.getHabitantes().add(uryu);
		
		Armamento armaQuincy = new Armamento(" ", ArmType.ARMAMENTO_ESPIRITUAL);
		armaQuincy.setDescricao("Mata todos os demonios");
		armaQuincy.getHabilidade().set(0, aa);
		armaQuincy.setNome("Lanca nishirim");
		armaQuincy.setQuebrado(false);
		uryu.setEspada(armaQuincy);


		Demonio ar = new Demonio();
		Ser muzan = new Ser(ar);
		muzan.setLocalAtual(lasNotches);
		muzan.setMorto(true);
		muzan.setNome("Muzan");
		muzan.setReiatsu(3);
		lasNotches.getHabitantes().add(muzan);
		
		muzan.setEspada(new Armamento("Garras", ArmType.ZANPAKUTO));
		muzan.getEspada().getHabilidade().set(0, aa);
		
		
		Restrição h = new Restrição();
		Ser bonbocacha = new Ser(h);
		bonbocacha.setNome("Kanao");
		bonbocacha.setLocalAtual(lasNotches);
		lasNotches.getHabitantes().add(bonbocacha);
		bonbocacha.setReiatsu(5);

		Alma a = new Alma();
		Ser almaQualquer = new Ser(a);
		almaQualquer.setNome("desconhecido");
		//almaQualquer.getRaca().setId(7);
		almaQualquer.setLocalAtual(cidadePrincipal);
		Beppu.getHabitantes().add(almaQualquer);
		
//-------------------------segundo persist-------------------------------------			
//		em.getTransaction().begin();
//		em.persist(aa);
//		em.getTransaction().commit();
		
//-----------------------------------------------------------------------------
//		em.getTransaction().begin();
//		em.persist(shiP);
//		em.persist(a);
//		em.persist(h);
//		em.persist(ar);
//		em.persist(u);
//		em.persist(cap3);
//		em.persist(cap2);
//		em.persist(cap1);
//		em.getTransaction().commit();
//
//		em.getTransaction().begin();
//		em.persist(protagonista.getEspada());
//		em.persist(hashira1.getEspada());
//		em.persist(hashira2.getEspada());
//		em.persist(hashira3.getEspada());
//		em.persist(armaQuincy);
//		em.persist(muzan.getEspada());
//		em.getTransaction().commit();
//
//		em.getTransaction().begin();
//		em.persist(protagonista);
//		em.persist(almaQualquer);
//		em.persist(bonbocacha);
//		em.persist(muzan);
//		em.persist(uryu);
//		em.persist(hashira3);
//		em.persist(hashira2);
//		em.persist(hashira1);
//		em.getTransaction().commit();
//		
//		em.getTransaction().begin();
//		em.merge(primeira);
//		em.merge(decimaPrimeira);
//		em.merge(sexta);
//		em.merge(hashiras);
//		em.merge(Beppu);
//		em.merge(deserto);
//		em.merge(lasNotches);
//		em.merge(cidadeDasAlmas);
//		em.merge(cidadePrincipal);
		
		Armamento tanjiro = new Armamento("",ArmType.BANKAI);
		tanjiro.setNome("Tensa Zangetsu");
		tanjiro.especial().setNome("Getsuga Tensho");
		tanjiro.especial().setEfeito(25);
		tanjiro.especial().setTipo(EnumHabilidade.DANO);
		tanjiro.setDescricao("Katana negra");
		tanjiro.getHabilidade().add(aa);
			
		protagonista.getHabilidades().add(tanjiro.especial());
		//tanjiro ativa sua respiração
		protagonista.getEspada().liberar(protagonista, tanjiro);
		
		hashira2.getRaca().setDefesa(19);
		protagonista.getRaca().setForca(20);
		
//
//		em.persist(tanjiro.especial());
//		em.persist(tanjiro);
//		em.merge(hashira2);
//		em.merge(protagonista);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	
}
