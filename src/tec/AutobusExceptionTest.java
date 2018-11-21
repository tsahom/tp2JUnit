package tec;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class AutobusExceptionTest {

	@Test 
	void test() {
		assertThrows(IllegalArgumentException.class,new Autobus(-5,20));
	}

}
