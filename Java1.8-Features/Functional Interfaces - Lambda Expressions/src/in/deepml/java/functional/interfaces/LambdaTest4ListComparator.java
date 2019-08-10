package in.deepml.java.functional.interfaces;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import in.deepml.java.functional.interfaces.models.Employee;

public class LambdaTest4ListComparator {

public static void main(String[] args) {
		
		// UseCase: Create a Array List with Custom Sorting with Comparator (By Salary DESC) and print 
	
		Employee employee1 = new Employee(1, "Suresh Kumar", "Team Lead", 30000.00, "Bangalore");
		Employee employee2 = new Employee(2, "Mahesh Patil", "Developer", 20000.00, "Bangalore");
		Employee employee3 = new Employee(3, "Sandeep Saini", "Developer", 25000.00, "New Delhi");
		Employee employee4 = new Employee(4, "Tarun", "Manager", 45000.00, "Mumbai");
		
		// Create a list of employees. Print unsorted
		List<Employee> empList = new ArrayList<>();
		empList.add(employee1);
		empList.add(employee2);
		empList.add(employee3);
		empList.add(employee4);
		
		System.out.println("Unsorted List of Employees : ");
		System.out.println(empList);
		
		/*** Without Lambda Expression : Start ***/
		// 1. Create a comparator class (OR Anonymous Inner class) implementing comparator interface
		Comparator<Employee> empComparator = new Comparator<Employee>() {

			@Override
			public int compare(Employee obj1, Employee obj2) {
				if(obj1.getSalary() > obj2.getSalary()) { // Return -1 to put obj1 before obj2
					return -1;
				} else if (obj1.getSalary() < obj2.getSalary()) { // Return 1 to put obj1 after obj2
					return 1;
				} else { // Return 0 of both are equal
					return 0;
				}
			}
		};
		// 2. Apply Sorting with comparator and print
		empList.sort(empComparator);
		System.out.println("Sorted List of Employees without Lambda : ");
		System.out.println(empList);
		
		/*** Without Lambda Expression : End ***/
		
		System.out.println("\n=========");
		
		/*** With Lambda Expression : Start ***/
		
		Comparator<Employee> empComparator2 = (obj1, obj2) -> obj1.getSalary() > obj2.getSalary() ? -1 : obj1.getSalary() < obj2.getSalary() ? 1: 0;
		empList.sort(empComparator2);
		System.out.println("Sorted List of Employees with Lambda : ");
		System.out.println(empList);
		
		empList.sort((obj1, obj2) -> obj1.getSalary() > obj2.getSalary() ? -1 : obj1.getSalary() < obj2.getSalary() ? 1: 0);
		System.out.println("Sorted List of Employees with Only Lambda Expression: ");
		System.out.println(empList);
		
		/*** With Lambda Expression : End ***/
	
	}
}
