package in.deepml.java.functional.interfaces;

import java.util.function.BiFunction;

public class BiFunctionTests {

	public static void main(String[] args) {

		// Function is a functional Interface with apply abstract method
		// It can accept TWO objects as input and can return any object as output
		// Rest of the functionality is exactly same

		// UseCase: Append String infront of Integer values
		BiFunction<Integer, String, String> prepareInvoiceName = (i, s) -> s + i;
		System.out.println(String.format("Generated invoice number for %s is %s", 8, prepareInvoiceName.apply(8, "INV_")));
		System.out.println(String.format("Generated invoice number for %s is %s", 34, prepareInvoiceName.apply(34, "INV_")));
		
	}
}
