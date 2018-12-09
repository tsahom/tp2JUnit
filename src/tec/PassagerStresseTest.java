package tec;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PassagerStresseTest extends PassagerAbstraitTest {

	@BeforeEach
	void setUp() throws Exception {
		debout = new PassagerStresse("Michel", 2);
		debout.accepterPlaceDebout();
		assis = new PassagerStresse("Suzie",3);
		assis.accepterPlaceAssise();
		dehors = new PassagerStresse("Luc", 3);
		busAssis = new FauxBusAssis();
		busDebout = new FauxBusDebout();
		busVide = new FauxBusVide();
		busPlein = new FauxBusPlein();
	}

	@Override
	void testNouvelArret() throws UsagerInvalideException {
		assis.nouvelArret((Bus)busVide, 0);
		assertTrue(assis.estAssis());
		assis.nouvelArret((Bus)busVide, 1);
		assertTrue(assis.estDebout());
		assis.nouvelArret((Bus)busVide, 2);
		assertTrue(assis.estDebout());
		assis.nouvelArret((Bus)busVide, 3);
		assertTrue(assis.estDehors());
	}

	@Override
	void testMonterDans() throws UsagerInvalideException {
		assis.accepterSortie();
		debout.accepterSortie();
		assis.monterDans(busAssis);
		assertTrue(assis.estAssis());
		debout.monterDans(busDebout);
		assertTrue(debout.estDehors());
	}
	


}
