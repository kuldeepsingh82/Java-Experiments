package in.deepml.java.functional.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

import in.deepml.java.functional.interfaces.models.Employee;

public class BiPredicateTests {

	public static void main(String[] args) {

		// BiPredicate is a functional Interface with test abstract method which accept TWO inputs and return boolean
		// Rest of the functionality is exactly same
		
		// UseCase: Test as Integer is greater than 10
		BiPredicate<Integer, Integer> isGreaterThan = (i, j) -> i > j;
		System.out.println(String.format("Test the Integer is greater than or not : %s", isGreaterThan.test(8, 20)));
		System.out.println(String.format("Test the Integer is greater than or not : %s", isGreaterThan.test(34, 12)));
		
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
		
		System.out.println("\nEmployees with Salary more than");
		BiPredicate<Employee, Integer> employeeWithSalaryMoreThan = (e, s) -> e.getSalary() > s;
		for (Employee employee : empList) {
			if(employeeWithSalaryMoreThan.test(employee, 20000)) {
				System.out.println(employee);	
			}
		}
		
		// Negate
		System.out.println("\nEmployees with Salary less than");
		for (Employee employee : empList) {
			if(employeeWithSalaryMoreThan.negate().test(employee, 20000)) {
				System.out.println(employee);	
			}
		}
	}
}
