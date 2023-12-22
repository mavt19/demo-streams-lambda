package mains;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ejercicios {

	public static void main(String[] args) {
		String str = "aaabbcc";// output a3b2c2
		int entrada = 38;
//		System.out.println(countCharacterFunctional(str));
		System.out.println(recursividadSumaDigitos(entrada));

	}

	
	/*
	 * 
	 * Now, starting again from a list of names, 
	 * give me the total number of letters 
	 * in all the names with more than 5 letters
	 * 
	 * */
	
	public static int getTotalNumberOfLettersOfNamesLongerThanFive(String... names) {
		
		return Stream.of(names)
		.filter(str -> str.length() > 5)
		.mapToInt(String::length)
		.sum();
	}

	
	
	/* 
	 * crear un metodo que dado un numero entero, suma repetidamente 
	 * todos sus digitos hasta que solo tenga un digito y devuelvelo
	 * ejemplo entrada 38
	 * 3+8 -> 11 1+1 -> 2
	 * ejemplo salida 2
	 * 
	 */
	
	public static int recursividadSumaDigitos(int entrada) {
		if(String.valueOf(entrada).length() == 1) {
			return entrada;
		}
		else {
			System.out.println("entrada : " + String.valueOf(entrada));
			Integer result = Stream.of(String.valueOf(entrada)
			.split(""))
			.mapToInt(Integer::parseInt)
			.sum();
//			.reduce(0, (x,y) -> x+y);1
			return recursividadSumaDigitos(result);
		}
	}
	
	/* 
	 * crear un metodo que cuente la cantidad de caracteres en un string
	 * ejemplo entrada aaabbbccc
	 * ejemplo salida a3b3c3
	 * 
	 */
	public static String countCharacter(String str) {
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

	public static String countCharacterFunctional(String str) {
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
