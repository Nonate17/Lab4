import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class lab4 {

	public static void main(String[] args) {
// Strings cannot be changed, while a stringbuilder can be updated. "so we dont create multiple objects"
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			if (i !=9) {
				sb.append(i + "-");
		}else {
			sb.append(i);
		}
	}
		System.out.println(sb.toString());
		
		List<String> strings = new ArrayList<String>();
		strings.add("Tali");
		strings.add("Sammy");
		strings.add("Paul");
		strings.add("I");
		strings.add("Me");
		System.out.println(strings);
		System.out.println(findShortString(strings));
		List<String> swapped = switchFirst(strings);
	for (String string : swapped) {
		System.out.println(string);
	System.out.println(combineStrings(swapped));	
	System.out.println("================");
	List<String>searchResults = search(strings, "a");
	for (String result : searchResults) {
		System.out.println(result);
	}
	List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 15, 20, 30);
	List<List<Integer>> sortedNumbers = sortDivisible(numbers);
	for ( List<Integer> list : sortedNumbers) {
		for (Integer number : list) {
			System.out.println(number);
		}
		System.out.println("Next List=============");
	}
	List<Integer> stringsLengths = calculateString(strings);
	for (Integer i : stringsLengths) {
		System.out.println(i);
	}
	Set<String> set = new HashSet<String>();
	set.add("Hello");
	set.add("World");
	set.add("Goodbye");
	set.add("Hi");
	set.add("Hello again");
	
	Set<String> startsWithH = startsWith(set, 'H');
	for (String word : startsWithH) {
		System.out.println(word);
	}
	List<String> resultList = convertSet(set);
	for (String listString : resultList) {
		System.out.println(listString);
	}
	Set<Integer> integerSet = new HashSet<Integer>();
		integerSet.add(3);
		integerSet.add(4);
		integerSet.add(8);	
		integerSet.add(33);
	Set<Integer> extractedEvens = extractEvens(integerSet);
	for (Integer number : extractedEvens) {
		System.out.println(number);
	}
	Map<String,String> dictionary = new HashMap<String,String>();
	dictionary.put("Apple", "Crunchy fruit.");
	dictionary.put("Banana", " A yellow fruit which you peel");
	dictionary.put("Java", " A programming language");
	String value = lookupValue (dictionary, "Apple");
	System.out.println(value);
	Map<Character, Integer> counts = countStart(resultList);
	for (Character character : counts.keySet()) {
		System.out.println(character + " - " + counts.get(character));
	}
	
	
	
	
	
	
	
	
	
	
	}	
	}
public static String findShortString(List<String> list) {
	String shortest = list.get(0);
	for (String string : list) {
		if (string.length() < shortest.length()) {
			
		
		shortest = string;
		}
	}
	return shortest;
}
public static List<String> switchFirst(List<String> list){
	String temp = list.get(0);
	list.set(0, list.get(list.size()- 1));
list.set(list.size() - 1, temp);
return list;
}
public static String combineStrings(List<String> strings) {
	StringBuilder result = new StringBuilder();
	for (String string : strings) {
		result.append(string + ", ");
	}
	return result.toString();
}
public static List<String> search(List<String> list, String query){
	List<String> results = new ArrayList<String>();
	for (String string : list) {
		if (string.contains(query)) {
			results.add(string);
		}
	}
	return results;
}
public static List<List<Integer>> sortDivisible(List<Integer> list){
	List<List<Integer>> results = new ArrayList<List<Integer>>();
	results.add(new ArrayList<Integer>());
	results.add(new ArrayList<Integer>());
	results.add(new ArrayList<Integer>());
	results.add(new ArrayList<Integer>());
	
	for (Integer number : list) {
		if (number % 2 == 0) {
			results.get(0).add(number);
				
		}
		if (number % 3 == 0) {
			results.get(1).add(number);
		}
		if (number % 5 == 0) {
			results.get(2).add(number);
		}
		if (number % 2 != 0 && number % 3 != 0 && number % 5 != 0) {
			results.get(3).add(number);
		}
	}
	return results;
	 
	}
public static List<Integer> calculateString(List<String> list) {
	List<Integer> lengths = new ArrayList<Integer>();
	for (String string : list) {
		lengths.add(string.length());
	}
	return lengths;
}
public static Set<String> startsWith(Set<String> set, char c) {
	Set<String> results = new HashSet<String>();
	for ( String string : set) {
		if ( string.charAt(0) == c) {
			results.add(string);
		}
	}
	return results;

}	
public static List<String> convertSet(Set<String> set){
	List<String> results = new ArrayList<String>();
	for (String string : set) {
		results.add(string);
	}
	return results;
}
public static Set<Integer> extractEvens(Set<Integer> set) {
	Set<Integer> results = new HashSet <Integer>();
	for (Integer number : set) {
		if (number % 2 == 0) {
			results.add(number);
		}
	}
	return results;
}
public static String lookupValue(Map<String, String> map, String string) {
	for (String key : map.keySet()) {
		if (key.equals(string)) {
			return map.get(key);
		}
	}
	return "";
}
public static Map<Character, Integer> countStart(List<String> list) {
	
	Map<Character,Integer> results = new HashMap<Character, Integer>();
	for ( String string : list) {
		char c = string.charAt(0);
		if (results.get(c) == null) {
			results.put(c,  1);
		}else {
			results.put(c,  results.get(c) + 1);
		}
	}
	return results;
}

}
