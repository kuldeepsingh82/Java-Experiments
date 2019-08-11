package in.deepml.java.functional.interfaces.service.impl;

import in.deepml.java.functional.interfaces.models.Employee;
import in.deepml.java.functional.interfaces.services.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public String getName(Employee employee) {
		System.out.println("EmployeeServiceImpl->getName : getting employee name");
		return employee.getFullName();
	}

}
