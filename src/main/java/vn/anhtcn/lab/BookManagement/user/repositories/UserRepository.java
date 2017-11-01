package vn.anhtcn.lab.BookManagement.user.repositories;

import vn.anhtcn.lab.BookManagement.user.model.User;

public interface UserRepository {
	public void create(User user);
	public void update(User user);
	public void delete(int id);	
	public User getByEmailPassword(String email, String password);
}
