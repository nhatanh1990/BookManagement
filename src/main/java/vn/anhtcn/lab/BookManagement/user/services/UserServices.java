package vn.anhtcn.lab.BookManagement.user.services;

import vn.anhtcn.lab.BookManagement.user.model.User;

public interface UserServices {
	public void create(User user);
	public void update(User user);
	public void delete(int id);	
	public User getByEmailPassword(String email, String password);
}
