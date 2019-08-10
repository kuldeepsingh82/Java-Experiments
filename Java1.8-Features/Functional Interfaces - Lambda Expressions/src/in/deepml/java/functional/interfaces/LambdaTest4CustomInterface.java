package in.deepml.java.functional.interfaces;

import in.deepml.java.functional.interfaces.models.Employee;
import in.deepml.java.functional.interfaces.service.impl.EmployeeServiceImpl;
import in.deepml.java.functional.interfaces.services.EmployeeService;

public class LambdaTest4CustomInterface {

public static void main(String[] args) {
		
		// UseCase: Use User Service interface and get user name by user object
	
		Employee employee = new Employee(1, "Suresh Kumar", "Team Lead", 30000.00, "Bangalore");
		
		// Without Lambda Expression
		EmployeeService employeeService = new EmployeeServiceImpl();
		String employeeName = employeeService.getName(employee);
		System.out.println(String.format("Employee name with traditional approach : %s", employeeName));
		
		System.out.println("\n=========");
		// With Lambda Expression
		// No need to implement the interface. Interface implementation is provided by the lambda expression
		EmployeeService employeeLambdaService = e -> e.getFullName();
		System.out.println(String.format("Employee name with lambda expression : %s", employeeLambdaService.getName(employee)));
	
	}
}
