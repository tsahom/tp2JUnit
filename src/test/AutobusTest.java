package test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tec.Autobus;
import tec.PassagerStandard;

class AutobusTest {

	public Autobus auto1, auto2;
	public PassagerStandard pass1, pass2;
	
	@BeforeEach
	public  void setUp(){
		pass1 = new PassagerStandard("Billy", 5);
		pass2 = new PassagerStandard("Tommy", 5);
	}
	
	@Test
	void constructeurTestCasStandart() {
		this.auto1 = new Autobus(20,20);
		assertTrue(auto1.aPlaceAssise());
		assertTrue(auto1.aPlaceDebout());
	}
	
	@Test
	void constructeurTestcasVide() {

		this.auto1 = new Autobus(1,1);
		auto1.demanderPlaceAssise(pass1);
		auto1.demanderPlaceDebout(pass2);
		assertTrue(!auto1.aPlaceAssise());
		assertTrue(!auto1.aPlaceDebout());
	}
	@Test
	void constructeurTestunVide() {
		this.auto1 = new Autobus(1,1);

		auto1.demanderPlaceDebout(pass1);
		assertTrue(auto1.aPlaceAssise());
		assertTrue(!auto1.aPlaceDebout());
		
		this.auto2 = new Autobus(1,1);
		auto2.demanderPlaceAssise(pass2);
		assertTrue(!auto2.aPlaceAssise());
		assertTrue(auto2.aPlaceDebout());
	}
	
	@Test
	void testModifier() {
		this.auto1 = new Autobus(1,1);
		assertTrue(auto1.aPlaceAssise());
		assertTrue(auto1.aPlaceDebout());
		auto1.demanderPlaceDebout(pass1);
		assertTrue(auto1.aPlaceAssise());
		assertTrue(!auto1.aPlaceDebout());
		auto1.demanderChangerEnAssis(pass1);
		assertTrue(!auto1.aPlaceAssise());
		assertTrue(auto1.aPlaceDebout());
	}
	
	
}
