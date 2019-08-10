package in.deepml.java.functional.interfaces.services;

import in.deepml.java.functional.interfaces.models.User;

// Regular interface with multiple abstract methods
public interface UserService {

	public String getName(User user);
	
	public User getUserById(Integer userId);
	
	public boolean delete(User user);
	
}
