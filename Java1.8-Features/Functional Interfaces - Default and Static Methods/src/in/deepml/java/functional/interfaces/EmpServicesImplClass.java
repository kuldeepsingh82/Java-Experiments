package in.deepml.java.functional.interfaces;

import in.deepml.java.functional.interfaces.models.Employee;
import in.deepml.java.functional.interfaces.service.extended.AnotherEmployeeServiceImpl;
import in.deepml.java.functional.interfaces.service.extended.EmployeeServiceImpl;

public class EmpServicesImplClass implements EmployeeServiceImpl, AnotherEmployeeServiceImpl {

	// Its is required to implement this function to avoid diamond method conflicts
	// We can call any super method if we don't want to implement our own functionality
	@Override
	public String diamondMethodConflict() {
		// return EmployeeServiceImpl.super.diamondMethodConflict();
		// OR
		return AnotherEmployeeServiceImpl.super.diamondMethodConflict();
		// OR
		// Our own implementation
	}

	@Override
	public String getName(Employee employee) {
		return "EmpServicesImplClass->getName : "+employee.getFullName();
	}

}
