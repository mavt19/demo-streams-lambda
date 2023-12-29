package mains;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

import model.Person;

class StreamsExampleTest {

	@Test
	void transformShouldFlattenCollection() {
		List<List<String>> collection = List.of(List.of("Viktor", "Farcic"), List.of("John", "Doe", "Third"));
		List<String> expected = List.of("Viktor", "Farcic", "John", "Doe", "Third");
		assertEquals(StreamsExample.transformFunctional(collection), expected);

		// assertj
		assertThat(StreamsExample.transform(collection)).hasSameElementsAs(expected);
	}

	@Test
	void getOldestPersonShouldReturnOldestPerson() {
		Person sara = new Person("Sara", 4, "");
		Person viktor = new Person("Viktor", 40, "");
		Person eva = new Person("Eva", 42, " ");
		List<Person> collection = List.of(sara, eva, viktor);
		assertEquals(StreamsExample.getOldestPersonFunctional(collection), eva);

		// assertj
		assertThat(StreamsExample.getOldestPerson(collection)).usingRecursiveComparison().isEqualTo(eva);
	}

	@Test
	void calculateShouldSumAllNumbers() {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5);
		assertEquals(StreamsExample.calculateFunctional(numbers), 1 + 2 + 3 + 4 + 5);

		// assertj
		assertThat(StreamsExample.calculate(numbers)).isEqualTo(1 + 2 + 3 + 4 + 5);
	}

	@Test
	void getKidNameShouldReturnNamesOfAllKidsUnder18() {
		Person sara = new Person("Sara", 4, "");
		Person viktor = new Person("Viktor", 40, "");
		Person eva = new Person("Eva", 42, "");
		Person anna = new Person("Anna", 5, "");
		List<Person> collection = List.of(sara, eva, viktor, anna);
		assertEquals(Set.of("Sara", "Anna"), StreamsExample.getKidNamesFunctional(collection));
		assertNotEquals(Set.of("Viktor", "Eva"), StreamsExample.getKidNamesFunctional(collection));

		// assertj
		assertThat(StreamsExample.getKidNames(collection)).contains("Sara", "Anna").doesNotContain("Viktor", "Eva");
	}

	@Test
	void partitionAdultsShouldSeparateKidsFromAdults() {
		Person sara = new Person("Sara", 4, "");
		Person viktor = new Person("Viktor", 40, "");
		Person eva = new Person("Eva", 42, "");
		List<Person> collection = List.of(sara, eva, viktor);
		Map<Boolean, List<Person>> result = StreamsExample.partitionAdultsFunctional(collection);
		assertEquals(List.of(eva, viktor), result.get(true));
		assertEquals(List.of(sara), result.get(false));

		// assertj
		assertThat(result.get(true)).hasSameElementsAs(List.of(viktor, eva));
		assertThat(result.get(false)).hasSameElementsAs(List.of(sara));
	}

	@Test
	void groupByNationalityTest() {
		Person sara = new Person("Sara", 4, "Norwegian");
		Person viktor = new Person("Viktor", 40, "Serbian");
		Person eva = new Person("Eva", 42, "Norwegian");
		List<Person> collection = List.of(sara, eva, viktor);
		Map<String, List<Person>> result = StreamsExample.groupByNationalityFunctional(collection);

		assertEquals(result.get("Norwegian"), List.of(sara, eva));
		assertEquals(result.get("Serbian"), List.of(viktor));

		// assertj
		assertThat(result.get("Norwegian")).hasSameElementsAs(List.of(sara, eva));
		assertThat(result.get("Serbian")).hasSameElementsAs(List.of(viktor));
	}

	@Test
	void toStringShouldReturnPeopleNamesSeparatedByComma() {
		Person sara = new Person("Sara", 4, "");
		Person viktor = new Person("Viktor", 40, "");
		Person eva = new Person("Eva", 42, "");
		List<Person> collection = List.of(sara, viktor, eva);
		assertEquals("Names: Sara, Viktor, Eva.", StreamsExample.namesToStringFunctional(collection));

		// assertj
		assertThat(StreamsExample.namesToString(collection)).isEqualTo("Names: Sara, Viktor, Eva.");
	}

}
