package in.deepml.java.functional.interfaces.services;

import in.deepml.java.functional.interfaces.models.Employee;

@FunctionalInterface //Annotation to ensure that there is only one abstract method in the interface
public interface SomeService {

	// An interface with only one abstract method
	public Employee getEmployeeObject();
}
