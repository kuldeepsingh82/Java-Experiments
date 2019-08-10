package in.deepml.java.functional.interfaces.models;

public class User {

	Integer userId;
	String fullName;
	String location;
	
	public Integer getEmpId() {
		return userId;
	}
	public void setEmpId(Integer empId) {
		this.userId = empId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", fullName=" + fullName + ", location=" + location + "]";
	}
}
