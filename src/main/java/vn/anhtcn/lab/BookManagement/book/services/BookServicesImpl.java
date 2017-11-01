package vn.anhtcn.lab.BookManagement.book.services;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.anhtcn.lab.BookManagement.book.model.Book;
import vn.anhtcn.lab.BookManagement.book.repositories.BookRepositories;

@Service
public class BookServicesImpl implements BookServices{

	@Autowired
	BookRepositories bookRepositories;
	@Override
	public void create(Book book) {
		
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+07"));
		book.setCreatedAt(new java.sql.Date(cal.getTimeInMillis()));	
		bookRepositories.create(book);
	}

	@Override
	public void update(Book book) {
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+07"));
		book.setUpdateAt(new java.sql.Date(cal.getTimeInMillis()));	
		bookRepositories.update(book);
	}

	@Override
	public void delete(int id) {
		bookRepositories.delete(id);
	}

	@Override
	public List<Book> findAll() {
		return bookRepositories.findAll();
	}

	@Override
	public Book findOne(int id) {
		return bookRepositories.findOne(id);
	}

	@Override
	public int countAllBook() {
		return bookRepositories.countAllBook();
	}

	@Override
	public List<Book> findAll(int start, int length) {
		return bookRepositories.findAll(start, length);
	}

}
