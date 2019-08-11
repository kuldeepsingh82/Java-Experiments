package in.deepml.java.functional.interfaces;

import in.deepml.java.functional.interfaces.models.Employee;
import in.deepml.java.functional.interfaces.services.EmployeeService;

public class MethodReferenceTests {

	public static void main(String[] args) {

		// Method Reference is an ALTERNATIVE to lambda expression
		// Mainly used for REUSABILITY of the functions
		// The function PARAMETERS should match
		// Both instance & static methods can be reference
		// Function name, return type, modifier can be different
		
		// UseCase : Difference between Lambda Expression & Method Reference for EmployeeService
		
		// 1. With Lambda Expression
		EmployeeService es = e -> e.getFullName();
		String esName = es.getName(new Employee(1, "With Lambda", null, null, null));
		System.out.println(esName);
		
		// 2. With Static Method reference
		EmployeeService essm = MethodReferenceTests::getEmployeeName;
		String esmName = essm.getName(new Employee(1, "With Static Method Reference", null, null, null));
		System.out.println(esmName);
		
		// 3. With Instance Method reference
		MethodReferenceTests mrTests = new MethodReferenceTests();
		EmployeeService esim = mrTests::getInstanceEmployeeName;
		String esimName = esim.getName(new Employee(1, "With Instance Method Reference", null, null, null));
		System.out.println(esimName);		
	}
	
	// Static Method can be referenced in place of Lambda expression
	public static String getEmployeeName(Employee employee) {
		return employee.getFullName();
	}
	
	public String getInstanceEmployeeName(Employee employee) {
		return employee.getFullName();
	}
}
