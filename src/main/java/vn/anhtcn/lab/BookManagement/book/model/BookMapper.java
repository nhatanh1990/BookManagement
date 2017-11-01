package vn.anhtcn.lab.BookManagement.book.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class BookMapper implements RowMapper<Book>{

	@Override
	public Book mapRow(ResultSet rs, int arg1) throws SQLException {
		Book book = new Book();
		
		book.setId(rs.getInt("id"));
		book.setTitle(rs.getString("title"));
		book.setAuthor(rs.getString("author"));
		book.setDescription(rs.getString("description"));
		book.setCreatedAt(rs.getDate("createdAt"));
		book.setUpdateAt(rs.getDate("updatedAt"));
		
		return book;
	}

}
