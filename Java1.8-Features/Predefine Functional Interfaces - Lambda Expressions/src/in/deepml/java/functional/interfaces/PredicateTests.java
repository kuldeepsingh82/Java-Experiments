package in.deepml.java.functional.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import in.deepml.java.functional.interfaces.models.Employee;

public class PredicateTests {

	public static void main(String[] args) {

		// Predicate is a functional Interface with test abstract method and return boolean
		
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
		for (Employee employee : empList) {
			if(employeeWithSalaryMoreThan20K.test(employee)) {
				System.out.println(employee);	
			}
		}
		
		// Negate
		System.out.println("\nEmployees with Salary less than 20K");
		for (Employee employee : empList) {
			if(employeeWithSalaryMoreThan20K.negate().test(employee)) {
				System.out.println(employee);	
			}
		}
		
		// Join Prediactes
		// Find Employees with Salary more than 20K and Developer
		System.out.println("\nEmployees with Salary more than 20K and are Developers");
		Predicate<Employee> developers = e -> e.getDesignation().equalsIgnoreCase("developer");
		for (Employee employee : empList) {
			if(employeeWithSalaryMoreThan20K.and(developers).test(employee)) {
				System.out.println(employee);	
			}
		}
	}
}
