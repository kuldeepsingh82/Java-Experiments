package in.deepml.java.functional.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import in.deepml.java.functional.interfaces.models.Employee;

public class FunctionTests {

	public static void main(String[] args) {

		// Function is a functional Interface with apply abstract method
		// It can accept any object as input and can return any object as output

		// UseCase: Append "INV_" infront of Integer values
		Function<Integer, String> prepareInvoiceName = i -> "INV_" + i;
		System.out.println(String.format("Generated invoice number for %s is %s", 8, prepareInvoiceName.apply(8)));
		System.out.println(String.format("Generated invoice number for %s is %s", 34, prepareInvoiceName.apply(34)));

		Function<String, String> stringTrimmer = s -> s.trim();
		System.out.println(String.format("\nTrimmed String is {%s}", stringTrimmer.apply(" abc xyz  ")));

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

		// Find total Monthly Salary in the company
		Function<List<Employee>, Double> countSalary = el -> {
			Double totalSalary = new Double(0);
			for (Employee e : el) {
				totalSalary += e.getSalary();
			}
			return totalSalary;
		};
		System.out.println(String.format("\nTotal Salary of Employees is %s ", countSalary.apply(empList)));

		// Increment the salary of employee by 10%
		Function<List<Employee>, List<Employee>> salaryIncrement10Percent = el -> {
			for (Employee e : el) {
				e.setSalary(e.getSalary()*1.10);
			}
			return el;
		};
		List<Employee> empListWithSalaryHike = salaryIncrement10Percent.apply(empList);
		System.out.println(String.format("\nTotal Salary of Employees after 10 Percent hike is %s ", countSalary.apply(empListWithSalaryHike)));

		
		// Combine Function with Predicate
		// Give Increment 10% to employee whose salary is less than 30K
		Predicate<Employee> isSalaryLessThan30K = e -> e.getSalary() < 30000;
		Function<Employee, Employee> incrementTheSalary = e -> { 
										e.setSalary(e.getSalary()*1.10); 
										return e;
		};
		System.out.println(String.format("\nTotal Salary of Employees now is %s ", countSalary.apply(empList)));
		List<Employee> empWithSalaryHike = new ArrayList<>();
		for (Employee employee : empList) {
			if(isSalaryLessThan30K.test(employee)) {
				empWithSalaryHike.add(incrementTheSalary.apply(employee));
			} else {
				empWithSalaryHike.add(employee);
			}
		}
		System.out.println(String.format("\nEmployees are %s ", empWithSalaryHike));
		System.out.println(String.format("\nTotal Salary of Employees now is %s ", countSalary.apply(empWithSalaryHike)));
		
		// Function Chaining (andThen or compose)
		// Use Case: Send Developers to on-site and change their designation to Sr Developer
		// 1. Predicate to find Developer
		Predicate<Employee> isDeveloper = e -> e.getDesignation().equalsIgnoreCase("developer");
		
		// 2. Function send them On-Site
		Function<Employee, Employee> sendOnSite = e -> { e.setLocation("New York"); return e;};
		
		// 3. Function to change the designation
		Function<Employee, Employee> changeDesignationToSrDeveloper = e -> { e.setDesignation("Sr. Developer"); return e;};
		List<Employee> newSrDevelopers = new ArrayList<>();
		for (Employee employee : empList) {
			if(isDeveloper.test(employee)) {
				//newSrDevelopers.add(sendOnSite.andThen(changeDesignationToSrDeveloper).apply(employee));
				//OR
				newSrDevelopers.add(sendOnSite.compose(changeDesignationToSrDeveloper).apply(employee));
			}
		}
		System.out.println(String.format("\nSr Developer Employees are %s ", newSrDevelopers));
		
	}
}
