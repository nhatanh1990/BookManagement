package vn.anhtcn.lab.BookManagement.user.repositories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vn.anhtcn.lab.BookManagement.user.model.User;
import vn.anhtcn.lab.BookManagement.user.model.UserMapper;

@Repository
public class UserRepositoryImpl implements UserRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void create(User user) {
		String sql = "INSERT INTO user "
				+ "(id, email, password, firstName, lastName) VALUES (seq_users_id.nextval, ?, ?, ?, ?)";
		jdbcTemplate.update(sql,
				new Object[] { user.getEmail(), user.getPassword(), user.getFirstName(), user.getLastName(), });
	}

	@Override
	public void update(User user) {
		String sql = "UPDATE user SET email = ?,password = ?" + ",firstName = ? ,lastName = ? where id = ?";
		jdbcTemplate.update(sql, new Object[] { user.getEmail(), user.getPassword(), user.getFirstName(),
				user.getLastName(), user.getId() });
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public User getByEmailPassword(String email, String password) {
		String sql = "SELECT * FROM user where UPPER(email) = ? && password = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new Object[] { email, password }, new UserMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (Exception e) {
			return null;
		}
	}
}
