package in.deepml.java.functional.interfaces;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import in.deepml.java.functional.interfaces.models.Employee;

public class LambdaTest4SetComparator {

	public static void main(String[] args) {

		// UseCase: Create a TreeSet with Custom Sorting with Comparator (By Salary
		// DESC) and print

		Employee employee1 = new Employee(1, "Suresh Kumar", "Team Lead", 30000.00, "Bangalore");
		Employee employee2 = new Employee(2, "Mahesh Patil", "Developer", 20000.00, "Bangalore");
		Employee employee3 = new Employee(3, "Sandeep Saini", "Developer", 25000.00, "New Delhi");
		Employee employee4 = new Employee(4, "Tarun", "Manager", 45000.00, "Mumbai");

		// Create a list of employees. Print unsorted
		Set<Employee> empSet = new HashSet<>();
		empSet.add(employee1);
		empSet.add(employee2);
		empSet.add(employee3);
		empSet.add(employee4);

		System.out.println("Unsorted Set of Employees : ");
		System.out.println(empSet);

		System.out.println("\n=========");
		
		/*** Without Lambda Expression : Start ***/
		// 1. Create a comparator class (OR Anonymous Inner class) implementing
		// comparator interface
		Comparator<Employee> empComparator = new Comparator<Employee>() {

			@Override
			public int compare(Employee obj1, Employee obj2) {
				if (obj1.getSalary() > obj2.getSalary()) { // Return -1 to put obj1 before obj2
					return -1;
				} else if (obj1.getSalary() < obj2.getSalary()) { // Return 1 to put obj1 after obj2
					return 1;
				} else { // Return 0 of both are equal
					return 0;
				}
			}
		};
		// 2. Add Items to set with comparator
		Set<Employee> empSetWithoutLambda = new TreeSet<>(empComparator);
		empSetWithoutLambda.add(employee1);
		empSetWithoutLambda.add(employee2);
		empSetWithoutLambda.add(employee3);
		empSetWithoutLambda.add(employee4);

		// 2. Print
		System.out.println("Sorted Set of Employees without Lambda : ");
		System.out.println(empSetWithoutLambda);

		/*** Without Lambda Expression : End ***/

		System.out.println("\n=========");

		/*** With Lambda Expression : Start ***/

		Comparator<Employee> empComparator2 = (obj1, obj2) -> obj1.getSalary() > obj2.getSalary() ? -1
				: obj1.getSalary() < obj2.getSalary() ? 1 : 0;
		Set<Employee> empSetWithLambda = new TreeSet<>(empComparator2);
		empSetWithLambda.add(employee1);
		empSetWithLambda.add(employee2);
		empSetWithLambda.add(employee3);
		empSetWithLambda.add(employee4);
		System.out.println("Sorted Set of Employees with Lambda : ");
		System.out.println(empSetWithLambda);

		/*** With Lambda Expression : End ***/

	}
}
