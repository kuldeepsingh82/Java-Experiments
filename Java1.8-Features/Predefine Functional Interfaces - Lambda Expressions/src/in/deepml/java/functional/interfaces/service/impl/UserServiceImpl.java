package in.deepml.java.functional.interfaces.service.impl;

import in.deepml.java.functional.interfaces.models.User;
import in.deepml.java.functional.interfaces.services.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public String getName(User user) {
		System.out.println("UserServiceImpl->getName : getting user name");
		return user.getFullName();
	}

	@Override
	public User getUserById(Integer userId) {
		System.out.println("UserServiceImpl->getUserById : getting User object By userId");
		return new User();
	}

	@Override
	public boolean delete(User user) {
		System.out.println("UserServiceImpl->delete : deleting User object");
		return true;
	}

}
