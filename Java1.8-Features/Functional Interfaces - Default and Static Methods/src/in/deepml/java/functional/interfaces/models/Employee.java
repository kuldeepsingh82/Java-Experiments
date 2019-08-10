package in.deepml.java.functional.interfaces.models;

public class Employee {

	Integer empId;
	String fullName;
	String designation;
	Double salary;
	String location;
	
	public Employee(Integer empId, String fullName, String designation, Double salary, String location) {
		super();
		this.empId = empId;
		this.fullName = fullName;
		this.designation = designation;
		this.salary = salary;
		this.location = location;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", fullName=" + fullName + ", designation=" + designation + ", salary="
				+ salary + ", location=" + location + "]";
	}
	
}
