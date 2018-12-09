	package tec;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PassagerStandardTest extends PassagerAbstraitTest{

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
	void testNouvelArret() throws UsagerInvalideException {
		assis.nouvelArret((Bus)busVide, 0);
		assertTrue(assis.estAssis());
		assis.nouvelArret((Bus)busVide, 1);
		assertTrue(assis.estAssis());
		assis.nouvelArret((Bus)busVide, 2);
		assertTrue(assis.estAssis());
		assis.nouvelArret((Bus)busVide, 3);
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
	}



}
