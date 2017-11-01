package vn.anhtcn.lab.BookManagement.book.services;

import java.util.List;

import vn.anhtcn.lab.BookManagement.book.model.Book;

public interface BookServices {
	public void create(Book book);

	public void update(Book book);

	public void delete(int id);

	public List<Book> findAll();

	public List<Book> findAll(int start, int length);

	public int countAllBook();

	public Book findOne(int id);
}
