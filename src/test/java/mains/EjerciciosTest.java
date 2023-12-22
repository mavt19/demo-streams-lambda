package mains;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EjerciciosTest {

	@Test
	void testGetTotalNumberOfLettersOfNamesLongerThanFive() {
	    System.out.println("Testing if [william, jones, aaron, seppe, frank, gilliam] returns 14");
	    assertEquals(Ejercicios.getTotalNumberOfLettersOfNamesLongerThanFive("william", "jones", "aaron", "seppe", "frank", "gilliam"), 14);

	    System.out.println("Testing if [aaron] returns 0");
	    assertEquals(Ejercicios.getTotalNumberOfLettersOfNamesLongerThanFive("aaron"), 0);
	}

	@Test
	void testRecursividadSumaDigitos() {
		int expected = 2;
		assertEquals(Ejercicios.recursividadSumaDigitos(38), expected);
	}

	@Test
	void testCountCharacter() {
		String expected = "a3b2c2";
		assertEquals(Ejercicios.countCharacter("aaabbcc"), expected);
	}

	@Test
	void testCountCharacterFunctional() {
		String expected = "a3b2c2";
		assertEquals(Ejercicios.countCharacterFunctional("aaabbcc"), expected);
	}

}
