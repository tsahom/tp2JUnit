package tec;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class AutobusExceptionTest {

	@Test 
	void testConstructeurValeurenegative() {
		Executable ex = ()->new Autobus(-5,5);
		assertThrows(IllegalArgumentException.class,ex);
		
		Executable ex2 = ()->new Autobus(5,-5);
		assertThrows(IllegalArgumentException.class,ex2);
		
		Executable ex3 = ()->new Autobus(-5,-5);
		assertThrows(IllegalArgumentException.class,ex3);
	}
	
	@Test 
	void testConstructeurValeureNulle() {
		Executable ex = ()->new Autobus(5,0);
		assertThrows(IllegalArgumentException.class,ex);
		
		Executable ex2 = ()->new Autobus(0,5);
		assertThrows(IllegalArgumentException.class,ex2);
		
		Executable ex3 = ()->new Autobus(0,0);
		assertThrows(IllegalArgumentException.class,ex3);
	}

}
