package in.deepml.java.functional.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import in.deepml.java.functional.interfaces.models.Employee;

public class PredicateTestWithHelperFunction {

	public static void main(String[] args) {

		// Predicate is a functional Interface with test abstract method and return
		// boolean

		// UseCase: Test as Integer is greater than 10
		Predicate<Integer> isGreaterThan10 = i -> i > 10;
		System.out.println(String.format("Test the Integer is greater than 10 or not : %s", isGreaterThan10.test(8)));
		System.out.println(String.format("Test the Integer is greater than 10 or not : %s", isGreaterThan10.test(34)));

		// UseCase: To test the Employee with salary more/less than 20000
		Employee employee1 = new Employee(1, "Suresh Kumar", "Team Lead", 30000.00, "Bangalore");
		Employee employee2 = new Employee(2, "Mahesh Patil", "Developer", 18000.00, "Bangalore");
		Employee employee3 = new Employee(3, "Sandeep Saini", "Developer", 25000.00, "New Delhi");
		Employee employee4 = new Employee(4, "Tarun", "Manager", 45000.00, "Mumbai");
		Employee employee5 = new Employee(4, "Kumar", "Developer", 15000.00, "Chennai");

		// Create a list of employees.
		List<Employee> empList = new ArrayList<>();
		empList.add(employee1);
		empList.add(employee2);
		empList.add(employee3);
		empList.add(employee4);
		empList.add(employee5);

		System.out.println("\nEmployees with Salary more than 20K");
		Predicate<Employee> employeeWithSalaryMoreThan20K = e -> e.getSalary() > 20000;
		PredicateTestWithHelperFunction.printEmployeers(employeeWithSalaryMoreThan20K, empList);

		// Negate
		System.out.println("\nEmployees with Salary less than 20K");
		PredicateTestWithHelperFunction.printEmployeers(employeeWithSalaryMoreThan20K.negate(), empList);

		// Join Prediactes : AND
		// Find Employees with Salary more than 20K and Developer
		System.out.println("\nEmployees with Salary more than 20K and are Developers");
		Predicate<Employee> developers = e -> e.getDesignation().equalsIgnoreCase("developer");
		PredicateTestWithHelperFunction.printEmployeers(developers.and(employeeWithSalaryMoreThan20K), empList);

		// Find employees who are developers OR are from Bangalore
		System.out.println("\nEmployees who are developers OR are from Bangalore");
		Predicate<Employee> fromBangalore = e -> e.getLocation().equalsIgnoreCase("bangalore");
		PredicateTestWithHelperFunction.printEmployeers(developers.or(fromBangalore), empList);
	}

	private static void printEmployeers(Predicate<Employee> predicate, List<Employee> employees) {
		for (Employee employee : employees) {
			if (predicate.test(employee)) {
				System.out.println(employee);
			}
		}
	}
}
