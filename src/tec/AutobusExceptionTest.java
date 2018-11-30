package tec;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class AutobusExceptionTest {

	
	/**
	 * On vérifie le fait que l'on ne puisse pas créer une autobus avec un nombre de place négatif
	 * 
	 */
	@Test 
	void testConstructeurValeurenegative() {
		Executable ex = ()->new Autobus(-5,5);
		assertThrows(IllegalArgumentException.class,ex);
		
		Executable ex2 = ()->new Autobus(5,-5);
		assertThrows(IllegalArgumentException.class,ex2);
		
		Executable ex3 = ()->new Autobus(-5,-5);
		assertThrows(IllegalArgumentException.class,ex3);
	}
	
	/**
	 * On vérifie le fait que l'on ne puisse pas créer une autobus avec un nombre de place égale à 0
	 * 
	 */
	@Test 
	void testConstructeurValeureNulle() {
		Executable ex = ()->new Autobus(5,0);
		assertThrows(IllegalArgumentException.class,ex);
		
		Executable ex2 = ()->new Autobus(0,5);
		assertThrows(IllegalArgumentException.class,ex2);
		
		Executable ex3 = ()->new Autobus(0,0);
		assertThrows(IllegalArgumentException.class,ex3);
	}
	
	/**
	 * On vérifie qu'on ne puisse pas demander la sortie d'un passager qui n'est pas dans le bus
	 */
	@Test
	void testDemanderSortieException() {
		Autobus aut = new Autobus(5,5);
		FauxPassager passager = new FauxPassager();
		Executable ex = ()->aut.demanderSortie(passager);
		assertThrows(UsagerInvalideException.class,ex);
	}
	

}
