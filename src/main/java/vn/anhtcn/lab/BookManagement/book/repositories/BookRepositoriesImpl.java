package vn.anhtcn.lab.BookManagement.book.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vn.anhtcn.lab.BookManagement.book.model.Book;
import vn.anhtcn.lab.BookManagement.book.model.BookMapper;

@Repository
public class BookRepositoriesImpl implements BookRepositories {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void create(Book book) {
		String sql = "INSERT INTO book (title, author, description, createdAt) VALUES ( ?, ?, ?, ?)";
		jdbcTemplate.update(sql,
				new Object[] { book.getTitle(), book.getAuthor(), book.getDescription(), book.getCreatedAt() });
	}

	@Override
	public void update(Book book) {
		String sql = "UPDATE book SET title = ? , author = ? , description = ?, UpdatedAt = ? WHERE id= ?";
		jdbcTemplate.update(sql, new Object[] { book.getTitle(), book.getAuthor(), book.getDescription(),
				book.getUpdateAt(), book.getId() });
	}

	@Override
	public void delete(int id) {
		String sql="DELETE FROM book WHERE id = ?";
		jdbcTemplate.update(sql,new Object[]{
				id
		});
	}

	@Override
	public List<Book> findAll() {
		String sql = "SELECT * FROM book";
		try {
			List<Book> books = jdbcTemplate.query(sql, new BookMapper());
			return books;
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Book findOne(int id) {
		String sql = "SELECT * FROM book where id = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new Object[] { id }, new BookMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int countAllBook() {
		String sql = "SELECT count(*) FROM book";
		try {
			return jdbcTemplate.queryForObject(sql, Integer.class);
		} catch (EmptyResultDataAccessException e) {
			return 0;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public List<Book> findAll(int start, int length) {
		String sql = "SELECT * FROM book  order by id"
				+ " LIMIT ? OFFSET ?";
		try {
			List<Book> books = jdbcTemplate.query(sql,new Object[] {length, start}, new BookMapper());
			return books;
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (Exception e) {
			return null;
		}
	}

}
