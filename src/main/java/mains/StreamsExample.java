package mains;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import model.Person;

public class StreamsExample {

	// FlatMap

	public static List<String> transform(List<List<String>> collection) {
		List<String> newCollection = new ArrayList<>();
		for (List<String> subCollection : collection) {
			for (String value : subCollection) {
				newCollection.add(value);
			}
		}
		return newCollection;
	}

	public static List<String> transformFunctional(List<List<String>> collection) {

		return collection.stream().flatMap(res -> res.stream()).collect(Collectors.toList());

	}

	// MaxAndComparator

	public static Person getOldestPerson(List<Person> people) {
		Person oldestPerson = new Person("", 0, "");
		for (Person person : people) {
			if (person.getAge() > oldestPerson.getAge()) {
				oldestPerson = person;
			}
		}
		return oldestPerson;
	}

	public static Person getOldestPersonFunctional(List<Person> people) {

		return people.stream().max(Comparator.comparingInt(Person::getAge)).orElse(null);

	}

	// SumAndReduce

	public static int calculate(List<Integer> numbers) {
		int total = 0;
		for (int number : numbers) {
			total += number;
		}
		return total;
	}

	public static int calculateFunctional(List<Integer> numbers) {
		return numbers.stream().reduce(0, (a, b) -> a + b);
	}

	// UnderAge

	public static Set<String> getKidNames(List<Person> people) {
		Set<String> kids = new HashSet<>();
		for (Person person : people) {
			if (person.getAge() < 18) {
				kids.add(person.getName());
			}
		}
		return kids;
	}

	public static Set<String> getKidNamesFunctional(List<Person> people) {

		return people.stream().filter(p -> p.getAge() < 18).map(Person::getName).collect(Collectors.toSet());

	}

	// PartitionBy

	public static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {
		Map<Boolean, List<Person>> map = new HashMap<>();
		map.put(true, new ArrayList<>());
		map.put(false, new ArrayList<>());
		for (Person person : people) {
			map.get(person.getAge() >= 18).add(person);
		}
		return map;
	}

	public static Map<Boolean, List<Person>> partitionAdultsFunctional(List<Person> people) {

		return people.stream().collect(Collectors.partitioningBy(p -> p.getAge() >= 18));

	}

	// GroupBy

	public static Map<String, List<Person>> groupByNationality(List<Person> people) {
		Map<String, List<Person>> map = new HashMap<>();
		for (Person person : people) {
			if (!map.containsKey(person.getNationality())) {
				map.put(person.getNationality(), new ArrayList<>());
			}
			map.get(person.getNationality()).add(person);
		}
		return map;
	}

	public static Map<String, List<Person>> groupByNationalityFunctional(List<Person> people) {

		Map<String, Person> resultToMap = people.stream().collect(Collectors.toMap(Person::getNationality, Function.identity(), (oldKey, newKey) -> newKey));
		Map<String, Integer> resultToMap2 = people.stream().collect(Collectors.toMap(Person::getName, Person::getAge, (oldKey, newKey) -> newKey));
		Map<Person, Long> resultToMap3 = people.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(resultToMap + "" + resultToMap2);
		System.out.println(resultToMap3);
		return people.stream().collect(Collectors.groupingBy(Person::getNationality, Collectors.toList()));

	}

	// Joining

	public static String namesToString(List<Person> people) {
		String label = "Names: ";
		StringBuilder sb = new StringBuilder(label);
		for (Person person : people) {
			if (sb.length() > label.length()) {
				sb.append(", ");
			}
			sb.append(person.getName());
		}
		sb.append(".");
		return sb.toString();
	}

	public static String namesToStringFunctional(List<Person> people) {

		return people.stream().map(Person::getName).collect(Collectors.joining(", ", "Names: ", "."));

	}
}
