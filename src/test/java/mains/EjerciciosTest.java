package mains;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class EjerciciosTest {

	@Test
	void testGetTotalNumberOfLettersOfNamesLongerThanFive() {
		System.out.println("Testing if [william, jones, aaron, seppe, frank, gilliam] returns 14");
		assertEquals(Ejercicios.getTotalNumberOfLettersOfNamesLongerThanFive("william", "jones", "aaron", "seppe",
				"frank", "gilliam"), 14);

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

	@Test
	void getStringShouldOutputEvenUnevenString() {
		assertEquals(Ejercicios.getString(List.of(3, 44)), "o3,e44");
		assertEquals(Ejercicios.getString(List.of(3)), "o3");
	}

}
