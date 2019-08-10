package in.deepml.java.functional.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import in.deepml.java.functional.interfaces.models.Employee;

public class ConsumerTests {

	public static void main(String[] args) {

		// Consumer is a functional Interface with accept abstract method
		// It can accept any object as input and DOES NOT return anything

		// Print the String
		Consumer<String> printThis = s -> System.out.println(s);
		printThis.accept("DeepML");

		// Print the Object(s)
		// UseCase: To test the Employee with salary more/less than 20000
		Employee employee1 = new Employee(1, "Suresh Kumar", "Team Lead", 30000.00, "Bangalore");
		Employee employee2 = new Employee(2, "Mahesh Patil", "Developer", 18000.00, "Bangalore");
		Employee employee3 = new Employee(3, "Sandeep Saini", "Developer", 25000.00, "New Delhi");
		Employee employee4 = new Employee(4, "Tarun", "Manager", 45000.00, "Mumbai");
		Employee employee5 = new Employee(4, "Kumar", "Developer", 15000.00, "Chennai");

		// Create a list of employees in a format
		List<Employee> empList = new ArrayList<>();
		empList.add(employee1);
		empList.add(employee2);
		empList.add(employee3);
		empList.add(employee4);
		empList.add(employee5);

		Consumer<Employee> printObject = e -> System.out.println(e.getFullName() + ", " + e.getDesignation() + ", " + e.getLocation());
		System.out.println("\n==================");
		for (Employee employee : empList) {
			printObject.accept(employee);
		}
		
		// Combine Predicate, Function, Consumer
		// Find all Developers, Change their name to uppercase, print them
		
		// 1. Predicate to find developer
		Predicate<Employee> isDeveloper = e -> e.getDesignation().equalsIgnoreCase("developer");
		
		// 2. Function to update their name
		Function<Employee, Employee> toUpperCase = e -> { e.setFullName(e.getFullName().toUpperCase()); return e;};
		
		// 3. Consumer to print them 
		Consumer<Employee> printEmployee = e -> System.out.println(e.getFullName() + ", " + e.getDesignation() + ", " + e.getLocation());
		System.out.println("\n==================");
		System.out.println("All Developers with name in uppercase\n");
		// 4. Code to print the list
		for (Employee employee : empList) {
			if(isDeveloper.test(employee)) {
				printEmployee.accept(toUpperCase.apply(employee));
			}
		}
		
		// Consumer Chaining with andThen
		Consumer<String> printer = s -> System.out.println(s);
		Consumer<String> storage = s -> System.out.println("Storing something in DB");
		System.out.println("\n==================");
		printer.andThen(storage).accept("Print this");
	}
}
