package in.deepml.java.functional.interfaces.services;

import in.deepml.java.functional.interfaces.models.Employee;

@FunctionalInterface //Annotation to ensure that there is only one abstract method in the interface
public interface EmployeeService {

	// An interface with only one abstract method
	public String getName(Employee employee);
	
	// Functional interface can have any number of default methods.
	default void printTheName(Employee employee) {
		System.out.println("EmployeeServiceInterface->printTheName : Employee name is "+employee.getFullName());
	}

	default void printTheEmployee(Employee employee) {
		System.out.println("EmployeeServiceInterface->printTheEmployee : "+ employee);
	}
	
	// Problem with multiple inheritance 
	default String diamondMethodConflict() {
		System.out.println("EmployeeServiceInterface->diamondMethodConflict");
		return "EmployeeServiceInterface->diamondMethodConflict";
	}
	
	
	// Functional interface can have any number of static methods
	// These are kind of helper methods
	public static void sayHi() {
		System.out.println("EmployeeServiceInterface->sayHi : Hi");
	}
	
	// Static methods also includes 'main' method in the interface. You can run interface now :)
	public static void main(String[] args) {
		System.out.println("EmployeeServiceInterface->main : Inside interface main method");
	}

}
