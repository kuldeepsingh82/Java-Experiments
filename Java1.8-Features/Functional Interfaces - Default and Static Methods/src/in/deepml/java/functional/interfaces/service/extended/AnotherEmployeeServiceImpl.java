package in.deepml.java.functional.interfaces.service.extended;

import in.deepml.java.functional.interfaces.services.EmployeeService;

public interface AnotherEmployeeServiceImpl extends EmployeeService {

	@Override
	default String diamondMethodConflict() {
		System.out.println("AnotherEmployeeServiceImpl->diamondMethodConflict");
		return "AnotherEmployeeServiceImpl->diamondMethodConflict";
	}
	
	// @Override : We cannot override static methods of parent interface, as they are not available to child interfaces or classes
	// But can define method with same signature. 
	// This will be treated as a different static function belongs to this Interface	
	public static void sayHi() {
		System.out.println("EmployeeServiceInterface->sayHi : Hi");
	}
}
