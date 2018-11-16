package test;
import tec.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * La classe de test pour tester les différents types de jauge
 * 
 */
public class JaugeTest {

	Jauge jVerte, jBleu,jRouge, jLimiteBleu, jLimiteRouge, jDeplacement,jEgaleSup;
	
	/**
	 * 
	 * Représente les différentes classes qui implémente JAUGE
	 *
	 */
	public enum TypeJauge{NATUREL}
	


	@After
	public void nettoyer() throws Exception {
		jVerte = null;
		jBleu= null;
		jRouge= null;
		jLimiteBleu = null;
		jLimiteRouge = null;
		jDeplacement = null;
		jEgaleSup = null;
	}
	
	private Jauge creerJauge(TypeJauge type,long vigieMin, long vigieMax, long depart) {
		Jauge ret;
		switch(type) {
		case NATUREL:
			ret = new JaugeNaturel(vigieMin, vigieMax, depart);
			return ret;
		}
		return null;
	}
	
	/**
	 * La méthode va appeler tous les tests pour les différents type de jauge
	 */
	@Test
	public void runAll() {
		for(TypeJauge type :TypeJauge.values()) {
			jVerte= creerJauge(type,-345,67899,100);
			jBleu= creerJauge(type,-345,67899,-360);
			jRouge= creerJauge(type,-345,67899,67915);
			jLimiteBleu = creerJauge(type,-345,345,-345);
			jLimiteRouge = creerJauge(type,0, 500, 500);
			jDeplacement = creerJauge(type,-100,67899,-98);
			testDansIntervalle();
			testDeplacement();
			testInferieurIntervalle();
			testInferieurIntervalle2();
			testSuperieurIntervalle();
			testSuperieurIntervalle2();
			try {
			testExceptionControlee();
			}
			catch(ClassNotFoundException e) {
				
			}
		}
	}
	
	/**
	 * La méthode va lancer une ClassNotFoundException
	 * 
	 */
	public void testExceptionControlee() throws ClassNotFoundException{
		throw new ClassNotFoundException("Attention");
	}
	

	/**
	 *Etat après instanciation pour une valeur de départ dans l'intervalle de vigie.
	 */
	public void testDansIntervalle() {
		assertTrue("La jauge devrait etre verte", jVerte.estVert());
		assertTrue("La jauge ne devrait pas etre bleu", !jVerte.estBleu());
		assertTrue("La jauge ne devrait pas etre rouge", !jVerte.estRouge());
	}
	
	
	/**
	 * Test les méthodes incrémenter() et decrémenter()
	 */
	public void testDeplacement() {
		jDeplacement.decrementer();
		jDeplacement.decrementer();
		assertTrue("La jauge ne devrait pas etre verte", !jDeplacement.estVert());
		assertTrue("La jauge devrait etre bleu", jDeplacement.estBleu());
		assertTrue("La jauge ne devrait pas etre rouge", !jDeplacement.estRouge());
		jDeplacement.incrementer();
		jDeplacement.incrementer();
		assertTrue("La jauge devrait etre verte", jDeplacement.estVert());
		assertTrue("La jauge ne devrait pas etre bleu", !jDeplacement.estBleu());
		assertTrue("La jauge ne devrait pas etre rouge", !jDeplacement.estRouge());
	}
	
	
	/**
	 * Etat après instanciation pour une valeur de départ:  depart = vigieMin < vigieMax.
	 */
	public void testInferieurIntervalle()  {
		
		assertTrue("La jauge ne devrait pas etre verte", !jLimiteBleu.estVert());
		assertTrue("La jauge devrait etre bleu", jLimiteBleu.estBleu());
		assertTrue("La jauge ne devrait pas etre rouge", !jLimiteBleu.estRouge());
	}
	
	/**
	 * Etat après instanciation pour une valeur de départ: depart < vigieMin < vigieMax
	 */
	
	public void testInferieurIntervalle2()  {
		assertTrue("La jauge ne devrait pas etre verte", !jBleu.estVert());
		assertTrue("La jauge devrait etre bleu", jBleu.estBleu());
		assertTrue("La jauge ne devrait pas etre rouge", !jBleu.estRouge());
	}
	
	/**
	 * Etat après instanciation pour une valeur de départ: vigieMin < vigieMax = depart.
	 */
	public void testSuperieurIntervalle()  {
		
		assertTrue("La jauge ne devrait pas etre verte", !jLimiteRouge.estVert());
		assertTrue("La jauge ne devrait pas etre bleu", !jLimiteRouge.estBleu());
		assertTrue("La jauge devrait etre rouge", jLimiteRouge.estRouge());
	}
	
	/**
	 * Etat après instanciation pour une valeur de départ: vigieMin < vigieMax < depart 
	 */
	public void testSuperieurIntervalle2()  {
		assertTrue("La jauge ne devrait pas etre verte", !jRouge.estVert());
		assertTrue("La jauge ne devrait pas etre bleu", !jRouge.estBleu());
		assertTrue("La jauge devrait etre rouge", jRouge.estRouge());
	}
	
	
}
