package tec;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AutobusTest {

	public Autobus auto1, auto2, autoUnePlace;
	public FauxPassager pass1, pass2, pass3,pass4;
		
	@BeforeEach
	public  void setUp(){
		pass1 = new FauxPassager();
		pass2 = new FauxPassager();
		pass3 = new FauxPassager();
		autoUnePlace = new Autobus(1,1);
		this.auto1 = new Autobus(20,20);

	}
	/**
	 * Test des accesseurs aPlaceAssise et aPlaceDebout dans le cas ou il devrait retourner vrai (places disponibles)
	 * 
	 */
	@Test
	void accesseursTestCasStandart() {
		assertTrue(this.auto1.aPlaceAssise());
		assertTrue(this.auto1.aPlaceDebout());
	}
	/**
	 * Test des accesseurs aPlaceAssise et aPlaceDebout dans le cas ou il devrait retourner faux (Bus plein)
	 */
	@Test
	void accesseursTestcasVide(){
		this.autoUnePlace.demanderPlaceAssise(pass1);
		this.autoUnePlace.demanderPlaceDebout(pass2);
		assertTrue(!this.autoUnePlace.aPlaceAssise());
		assertTrue(!this.autoUnePlace.aPlaceDebout());
	}
	
	/**
	 * On test le cas il reste seulement des places assises ou des places debout 
	 * On fait cela pour s'assurer de l'indépendance des résultats de aPlaceAssise et aPlaceDebout
	 */
	@Test
	void constructeurTestunVide() {

		this.autoUnePlace.demanderPlaceDebout(pass1);
		assertTrue(this.autoUnePlace.aPlaceAssise());
		assertTrue(!this.autoUnePlace.aPlaceDebout());
		
		this.auto2 = new Autobus(1,1);
		auto2.demanderPlaceAssise(pass2);
		assertTrue(!auto2.aPlaceAssise());
		assertTrue(auto2.aPlaceDebout());
	}
	/**
	 * On test les modifiers suivant :
	 * demanderPlaceDebout
	 * demanderChangerEnAssis
	 * demanderChangerEnDebout
	 */
	@Test
	void testModifier() {
		assertTrue(this.autoUnePlace.aPlaceAssise());
		assertTrue(this.autoUnePlace.aPlaceDebout());
		autoUnePlace.demanderPlaceDebout(pass1);
		assertTrue(this.autoUnePlace.aPlaceAssise());
		assertTrue(!this.autoUnePlace.aPlaceDebout());
		this.autoUnePlace.demanderChangerEnAssis( pass1);
		assertTrue(!this.autoUnePlace.aPlaceAssise());
		assertTrue(this.autoUnePlace.aPlaceDebout());
		pass2.accepterPlaceAssise();
		assertEquals(pass1.message,pass2.message);
		this.autoUnePlace.demanderChangerEnDebout(pass1);
		assertTrue(this.autoUnePlace.aPlaceAssise());
		assertTrue(!this.autoUnePlace.aPlaceDebout());
		pass2.accepterPlaceDebout();
		assertEquals(pass1.message,pass2.message);
	}
	
	/**
	 * On vérifie que demanderSortie va bien appeler la méthode accepterSortie du Passager
	 * 
	 */
	@Test
	void testDemanderSortieAppelPassager() throws UsagerInvalideException {
		this.autoUnePlace.demanderPlaceDebout(pass1);
		this.autoUnePlace.demanderSortie(pass1);
		pass2.accepterSortie();
		assertEquals(pass1.message,pass2.message );
	}
	
	/**
	 * On vérifie que demanderPlace et DemanderChangerEn font appels aux bonne méthodes des Passagers
	 */
	@Test
	void testdemanderPlaceEtDemander() {
		
		this.auto1.demanderPlaceDebout(pass1);
		pass2.accepterPlaceDebout();
		assertEquals(pass1.message,pass2.message);
		
		this.auto1.demanderChangerEnAssis(pass1);
		pass2.accepterPlaceAssise();
		assertEquals(pass1.message,pass2.message);
		
		this.auto1.demanderPlaceAssise(pass3);
		pass2.accepterPlaceAssise();
		assertEquals(pass1.message,pass2.message);
		
		this.auto1.demanderChangerEnDebout(pass3);
		pass2.accepterPlaceDebout();
		assertEquals(pass3.message,pass2.message);	
	}
	
	/**
	 * On vérifie que l'autobus va notifier les passagers en cas d'appel de la méthode allerArretSuivant
	 * 
	 */
	@Test
	void testallerArretSuivant() throws UsagerInvalideException {
		this.auto1.demanderPlaceAssise(pass1);
		this.auto1.allerArretSuivant();
		assertEquals(pass1.message,":nouvelArret 1:");
	}
}
