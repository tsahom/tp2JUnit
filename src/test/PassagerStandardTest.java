package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tec.Autobus;
import tec.PassagerStandard;
import tec.UsagerInvalideException;

class PassagerStandardTest {

	PassagerStandard debout;
	PassagerStandard assis;
	PassagerStandard dehors;
	Autobus bus;

	@BeforeEach
	void setUp() throws Exception {
		debout = new PassagerStandard("Michel", 2);
		debout.accepterPlaceDebout();
		assis = new PassagerStandard("Suzie",3);
		assis.accepterPlaceAssise();
		dehors = new PassagerStandard("Luc", 3);
		bus = new Autobus(1,1);
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
		assis.nouvelArret(bus, 0);
		assertTrue(assis.estAssis());
		assis.nouvelArret(bus, 1);
		assertTrue(assis.estAssis());
		assis.nouvelArret(bus, 2);
		assertTrue(assis.estAssis());
		assis.nouvelArret(bus, 3);
		assertTrue(assis.estDehors());
		assis.nouvelArret(bus, 4);
		assertTrue(assis.estDehors());
	}

	@Test
	void testMonterDans() throws UsagerInvalideException{
		assis.accepterSortie();
		debout.accepterSortie();
		assis.monterDans(bus);
		assertTrue(assis.estAssis());
		debout.monterDans(bus);
		assertTrue(debout.estDebout());
		dehors.monterDans(bus);
		assertTrue(dehors.estDehors());

	}

	@Test
	void testToString() {
		assertEquals("Michel debout",debout.toString());
		assertEquals("Suzie assis",assis.toString());
		assertEquals("Luc dehors",dehors.toString());
	}

}
