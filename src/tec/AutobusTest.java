package tec;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AutobusTest {

	public Autobus auto1, auto2, autoUnePlace;
	public FauxPassager pass1, pass2;
		
	@BeforeEach
	public  void setUp(){
		pass1 = new FauxPassager();
		pass2 = new FauxPassager();
		autoUnePlace = new Autobus(1,1);
	}
	/**
	 * Test des accesseurs aPlaceAssise et aPlaceDebout dans en cas ou il devrait retourner vrai
	 * 
	 */
	@Test
	void accesseursTestCasStandart() {
		this.auto1 = new Autobus(20,20);
		assertTrue(this.auto1.aPlaceAssise());
		assertTrue(this.auto1.aPlaceDebout());
	}
	/**
	 * Test des accesseurs aPlaceAssise et aPlaceDebout dans en cas ou il devrait retourner faux (Bus plein)
	 */
	@Test
	void accesseursTestcasVide(){
		this.autoUnePlace.demanderPlaceAssise(pass1);
		this.autoUnePlace.demanderPlaceDebout(pass2);
		assertTrue(!this.autoUnePlace.aPlaceAssise());
		assertTrue(!this.autoUnePlace.aPlaceDebout());
	}
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
	
	@Test
	void testModifier() {
		assertTrue(this.autoUnePlace.aPlaceAssise());
		assertTrue(this.autoUnePlace.aPlaceDebout());
		autoUnePlace.demanderPlaceDebout( pass1);
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
	
	@Test
	void testDemanderSortie() throws UsagerInvalideException {
		this.autoUnePlace.demanderPlaceDebout(pass1);
		this.autoUnePlace.demanderSortie(pass1);
		pass2.accepterSortie();
		assertEquals(pass1.message,pass2.message );
	}
	
	

	
	@Test
	void testChangerEnAssis() {
		
	}
	
}
