package in.deepml.java.functional.interfaces;

import in.deepml.java.functional.interfaces.models.Employee;
import in.deepml.java.functional.interfaces.services.EmployeeService;

public class DefaultStaticMethodTest {

	public static void main(String[] args) {

		//We can call Interface Static Methods ONLY by Interface name
		EmployeeService.sayHi();
		
		//We cannot use by Class implementing the interface
		EmployeeService empServiceImpl = new EmpServicesImplClass();
		// Static Function Not available in the implemenated class
		//userServiceImpl.sayHi(); 
		
		// Will call the abstract method impl from child class
		String empName = empServiceImpl.getName(new Employee(1, "Test", "Lead", 20000.00, "Delhi"));
		System.out.println(empName);
		
		// Will call parent defualt method impl
		empServiceImpl.printTheEmployee(new Employee(1, "Another Test", "Developer", 20000.00, "Mumbai"));
	}
}
