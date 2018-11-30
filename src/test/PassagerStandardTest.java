package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tec.Autobus;
import tec.Bus;
import tec.FauxBusAssis;
import tec.FauxBusDebout;
import tec.FauxBusPlein;
import tec.FauxBusVide;
import tec.PassagerStandard;
import tec.Transport;
import tec.UsagerInvalideException;

class PassagerStandardTest {

	PassagerStandard debout;
	PassagerStandard assis;
	PassagerStandard dehors;
	FauxBusAssis busAssis;
	Transport busDebout;
	Transport busVide;
	Transport busPlein;

	@BeforeEach
	void setUp() throws Exception {
		debout = new PassagerStandard("Michel", 2);
		debout.accepterPlaceDebout();
		assis = new PassagerStandard("Suzie",3);
		assis.accepterPlaceAssise();
		dehors = new PassagerStandard("Luc", 3);
		busAssis = new FauxBusAssis();
		busDebout = new FauxBusDebout();
		busVide = new FauxBusVide();
		busPlein = new FauxBusPlein();
	}

	@Test
	void testNom() {
		assertEquals("Michel",debout.nom());
		assertNotEquals("Suzie",debout.nom());
		assertEquals("Suzie",assis.nom());
		assertNotEquals("Michel",assis.nom());
		assertEquals("Luc",dehors.nom());
		assertNotEquals("Michel",dehors.nom());
		assertNotEquals("Test",debout.nom());
	}

	@Test
	void testEstDehors() {
		assertFalse(debout.estDehors());
		assertFalse(assis.estDehors());
		assertTrue(dehors.estDehors());
	}

	@Test
	void testEstAssis() {
		assertFalse(debout.estAssis());
		assertTrue(assis.estAssis());
		assertFalse(dehors.estAssis());
	}

	@Test
	void testEstDebout() {
		assertTrue(debout.estDebout());
		assertFalse(assis.estDebout());
		assertFalse(dehors.estDebout());
	}

	@Test
	void testAccepterSortie() {
		assertFalse(debout.estDehors());
		debout.accepterSortie();
		assertTrue(debout.estDehors());
	}

	@Test
	void testAccepterPlaceAssie() {
		assertFalse(debout.estAssis());
		debout.accepterPlaceAssise();
		assertTrue(debout.estAssis());
	}

	@Test
	void testAccepterPlaceDebout() {
		assertFalse(assis.estDebout());
		assis.accepterPlaceDebout();
		assertTrue(assis.estDebout());
	}

	@Test
	void testNouvelArret() throws UsagerInvalideException {
		assis.nouvelArret((Bus)busVide, 0);
		assertTrue(assis.estAssis());
		assis.nouvelArret((Bus)busVide, 1);
		assertTrue(assis.estAssis());
		assis.nouvelArret((Bus)busVide, 2);
		assertTrue(assis.estAssis());
		assis.nouvelArret((Bus)busVide, 3);
		assertTrue(assis.estDehors());
		assis.nouvelArret((Bus)busVide, 4);
		assertTrue(assis.estDehors());
	}

	@Test
	void testMonterDans() throws UsagerInvalideException{
		assis.accepterSortie();
		debout.accepterSortie();
		assis.monterDans(busAssis);
		assertTrue(assis.estAssis());
		debout.monterDans(busDebout);
		assertTrue(debout.estDebout());
		dehors.monterDans(busPlein);
		assertTrue(dehors.estDehors());

	}

	@Test
	void testToString() {
		assertEquals("Michel debout",debout.toString());
		assertEquals("Suzie assis",assis.toString());
		assertEquals("Luc dehors",dehors.toString());
	}

}
