package mains;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ejercicios {

	public static void main(String[] args) {
		String str = "aaabbcc";// output a3b2c2
		int entrada = 9999992;
//		System.out.println(countCharacterFunctional(str));
		System.out.println(recursividadSumaDigitos(entrada));

	}

	/* 
	 * crear un metodo que dado un numero entero, suma repetidamente 
	 * todos sus digitos hasta que solo tenga un digito y devuelvelo
	 * ejemplo entrada 38
	 * 3+8 -> 11 1+1 -> 2
	 * ejemplo salida 2
	 * 
	 */
	
	private static int recursividadSumaDigitos(int entrada) {
		if(String.valueOf(entrada).length() == 1) {
			return entrada;
		}
		else {
			System.out.println("entrada : " + String.valueOf(entrada));
			Integer result = Stream.of(String.valueOf(entrada)
			.split(""))
			.map(Integer::parseInt)
			.reduce(0, (x,y) -> x+y);
			return recursividadSumaDigitos(result);
		}
	}
	
	/* 
	 * crear un metodo que cuente la cantidad de caracteres en un string
	 * ejemplo entrada aaabbbccc
	 * ejemplo salida a3b3c3
	 * 
	 */
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
