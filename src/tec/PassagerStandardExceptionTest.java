package tec;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class PassagerStandardExceptionTest {
	
	Transport busVide;
	Transport busPlein;
	PassagerStandard ps;
	PassagerStandard ps2;
	
	@BeforeEach
	void setUp() {
		ps2= new PassagerStandard("Michel", 2);
		ps = new PassagerStandard("Geraldine", 2);
		ps.accepterPlaceAssise();
		busVide = new FauxBusVide();
		busPlein = new FauxBusPlein();
	}

	@Test
	void testEtatPassagerIncoherent() {
		Executable ex = ()-> new PassagerStandard("Michel", 0);
		assertThrows(IllegalArgumentException.class,ex);
		
		Executable ex1 = ()-> ps.monterDans(busVide);
		assertThrows(IllegalStateException.class,ex1);
		
		Executable ex2 = ()-> ps2.nouvelArret((Bus)busVide, 3);;
		assertThrows(UsagerInvalideException.class,ex2);
		
		Executable ex3 = ()-> ps2.monterDans(busPlein);
		assertThrows(UsagerInvalideException.class,ex3);
		
		
	}

}
