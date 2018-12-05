package tec;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class PassagerAbstraitTest {

	PassagerAbstrait debout;
	PassagerAbstrait assis;
	PassagerAbstrait dehors;
	FauxBusAssis busAssis;
	Transport busDebout;
	Transport busVide;
	Transport busPlein;
	
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
	

}
