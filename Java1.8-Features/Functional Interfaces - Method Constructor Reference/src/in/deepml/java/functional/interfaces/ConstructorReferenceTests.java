package in.deepml.java.functional.interfaces;

import in.deepml.java.functional.interfaces.models.Employee;
import in.deepml.java.functional.interfaces.services.SomeService;

public class ConstructorReferenceTests {

	public static void main(String[] args) {

		// Constructor Reference is an ALTERNATIVE to lambda expression
		// Mainly used for REUSABILITY of the functions
		// The constructor PARAMETERS should match
		
		// UseCase : Difference between Lambda Expression & Method Reference for EmployeeService
		
		// 1. With Lambda Expression
		SomeService ss = () -> new Employee();
		Employee ssEmployee = ss.getEmployeeObject();
		System.out.println(ssEmployee);
		
		// 2. With Constructor reference
		SomeService ssc = Employee::new;
		Employee sscEmployee = ss.getEmployeeObject();
		System.out.println(sscEmployee);		
	}
	
	// Static Method can be referenced in place of Lambda expression
	public static String getEmployeeName(Employee employee) {
		return employee.getFullName();
	}
	
	public String getInstanceEmployeeName(Employee employee) {
		return employee.getFullName();
	}
}
