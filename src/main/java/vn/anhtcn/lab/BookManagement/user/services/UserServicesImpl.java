package vn.anhtcn.lab.BookManagement.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.anhtcn.lab.BookManagement.user.model.User;
import vn.anhtcn.lab.BookManagement.user.repositories.UserRepository;

@Service
public class UserServicesImpl implements UserServices {
	@Autowired
	private UserRepository userRepository;

	@Override
	public void create(User user) {
		userRepository.create(user);
	}

	@Override
	public void update(User user) {
		userRepository.update(user);
	}

	@Override
	public void delete(int id) {
		userRepository.delete(id);
	}

	@Override
	public User getByEmailPassword(String email, String password) {
		return userRepository.getByEmailPassword(email, password);
	}
}
