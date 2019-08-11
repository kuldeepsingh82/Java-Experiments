package in.deepml.java.streamapis;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIsTests {

	public static void main(String[] args) {

		List<Integer> intList = new ArrayList<>();
		intList.add(10);
		intList.add(15);
		intList.add(6);
		intList.add(19);
		intList.add(26);
		intList.add(4);
		intList.add(37);

		// Print the list with insertion order
		System.out.println("List elements => " + intList);

		// Filter the list and collect only even numbers
		List<Integer> evenNumberList = intList.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.println("Even number list => " + evenNumberList);

		// Map all objects, Increment all by 2 and collect
		List<Integer> incrementedNumberList = intList.stream().map(i -> i + 2).collect(Collectors.toList());
		System.out.println("List elements incremented by 2 => " + incrementedNumberList);

		// Find all odd numbers and get count
		long oddNumberCount = intList.stream().filter(i -> i % 2 != 0).count();
		System.out.println("Number of odd items in the list => " + oddNumberCount);

		// Sort the elements by natural sorting order and collect
		List<Integer> naturalSortedList = intList.stream().sorted().collect(Collectors.toList());
		System.out.println("List elements with natural sorting => " + naturalSortedList);

		// Sort the elements by custom sorting order (DESC) and collect
		List<Integer> customSortedList = intList.stream().sorted((obj1, obj2) -> obj2.compareTo(obj1)).collect(Collectors.toList());
		System.out.println("List elements with custom sorting => " + customSortedList);

		// Find min by custom sorting order (DESC) and get
		Integer minWithCustomSortedList = intList.stream().min((obj1, obj2) -> obj2.compareTo(obj1)).get();
		System.out.println("Min element with custom sorting => " + minWithCustomSortedList);

		// Find max by custom sorting order (DESC) and get
		Integer maxWithCustomSortedList = intList.stream().max((obj1, obj2) -> obj2.compareTo(obj1)).get();
		System.out.println("Max element with custom sorting => " + maxWithCustomSortedList);

		// Print all elements with forEach
		intList.stream().forEach(i-> System.out.println(i));
		// OR with method reference
		intList.stream().forEach(System.out::println);
		
		// Convert toArray and print
		Consumer<Integer> printer = s -> System.out.print(s+" ");
		Integer[] intArray = intList.stream().toArray(Integer[]::new);
		for (int j = 0; j < intArray.length; j++) {
			printer.accept(intArray[j]);
		}
		
		// Stream.of for permeative data types
		System.out.println();
		Integer[] intArrayElements = {9,11,2,5,17,6,7};
		Stream<Integer> s = Stream.of(intArrayElements);
		// Now can use this stream to perform any stream operation (Find Odd numbers)
		s.filter(k -> k%2 != 0).forEach(System.out::println);
		
	}
}
