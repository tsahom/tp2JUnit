package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tec.EtatPassager.Etat;
import tec.EtatPassager;

/**
 * Classe de test associée à EtatPassager.
 * 
 */
public class EtatPassagerTest {

	EtatPassager etDehors;
	EtatPassager etDebout;
	EtatPassager etAssis;

	/**
	 * Initialise toutes les differentes implementations possibles de EtatPassager
	 *  
	 * @throws Exception
	 */
	@Before
	public void initialiser() throws Exception {
		etDehors = new EtatPassager(Etat.DEHORS);
		etDebout = new EtatPassager(Etat.DEBOUT);
		etAssis = new EtatPassager(Etat.ASSIS);
	}

	/**
	 * Liberation de la memoire 
	 * 
	 * @throws Exception
	 */
	@After
	public void nettoyer() throws Exception {
		etDehors = null;
		etDebout = null;
		etAssis = null;
	}

	/**
	 * Teste si l'etat des EtatPassagerMonter est coherent ici si il est à l'exterieur
	 * 
	 * 
	 */
	@Test
	public void testEstExterieur() {
		assertFalse("L'etat devrait etre a l'exterieur",etAssis.estExterieur());
		assertFalse("L'etat devrait etre a l'exterieur",etDebout.estExterieur());
		assertTrue("L'etat devrait etre a l'exterieur",etDehors.estExterieur());
	}

	/**
	 * Teste si l'etat des EtatPassagerMonter est coherent ici si il est assis
	 * 
	 */
	@Test
	public void testEstAssis() {
		assertTrue("L'etat devrait etre assis",etAssis.estAssis());
		assertFalse("L'etat ne devrait pas etre assis",etDebout.estAssis());
		assertFalse("L'etat ne devrait pas etre assis",etDehors.estAssis());
	}

	/**
	 * Teste si l'etat des EtatPassagerMonter est coherent ici si il est debout
	 * 
	 */
	@Test
	public void testEstDebout() {
		assertTrue("L'etat devrait etre debout",etDebout.estDebout());
		assertFalse("L'etat ne devrait pas etre debout",etAssis.estDebout());
		assertFalse("L'etat ne devrait pas etre debout",etDehors.estDebout());
	}

	/**
	 * Teste si l'etat des EtatPassagerMonter est coherent ici si il est à l'interieur
	 * 
	 */
	@Test
	public void testEstInterieur() {
		assertTrue("Devrait etre a l'intérieur", etDebout.estInterieur());
		assertTrue("Devrait  etre a l'intérieur", etAssis.estInterieur());
		assertFalse("Ne devrait pas etre a l'in térieur", etDehors.estInterieur());
	}

}
