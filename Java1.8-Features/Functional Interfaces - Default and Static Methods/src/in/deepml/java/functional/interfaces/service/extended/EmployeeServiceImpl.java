package in.deepml.java.functional.interfaces.service.extended;

import in.deepml.java.functional.interfaces.models.Employee;
import in.deepml.java.functional.interfaces.services.EmployeeService;

public interface EmployeeServiceImpl extends EmployeeService {

	// We can override Functional Interface default methods here 
	// OR can use the parents method as is
	@Override
	default void printTheName(Employee employee) {
		System.out.println("EmployeeServiceImpl->printTheName : Employee name is " + employee.getFullName());
	}
	
	@Override
	default String diamondMethodConflict() {
		System.out.println("EmployeeServiceImpl->diamondMethodConflict");
		return "EmployeeServiceImpl->diamondMethodConflict";
	}
	
}
