package mains;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilterLambda {

	public static void main(String[] args) {
		String str = "aaabbcc";// output a3b2c2

		System.out.println(countCharacterFunctional(str));

	}

	private static String countCharacter(String str) {
		Map<Character, Integer> map = new HashMap<>();
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
			} else {
				map.put(str.charAt(i), 1);
			}
		}
		map.forEach((key, value) -> stringBuilder.append(key + "" + value));

		return stringBuilder.toString();
	}

	private static String countCharacterFunctional(String str) {
		Map<Character, Integer> map = new HashMap<>();

		IntStream.range(0, str.length()).forEach(i -> {
			if (map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
			} else {
				map.put(str.charAt(i), 1);
			}
		});

		return map.entrySet().stream().map(y -> {
			return y.getKey() + "" + y.getValue();
		}).collect(Collectors.joining());

	}

}
