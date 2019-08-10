package in.deepml.java.functional.interfaces;

import java.util.function.BiConsumer;

public class BiConsumerTests {

	public static void main(String[] args) {

		// BiConsumer is a functional Interface with accept abstract method
		// It can accept TWO objects as input and DOES NOT return anything
		// Rest of the functionality is exactly same

		// Append & Print the String
		BiConsumer<String, String> printThis = (s1, s2) -> System.out.println(s1+s2);
		printThis.accept("DeepML", "Test");
	}
}
