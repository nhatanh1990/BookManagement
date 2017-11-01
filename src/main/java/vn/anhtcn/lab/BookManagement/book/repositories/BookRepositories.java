package vn.anhtcn.lab.BookManagement.book.repositories;

import java.util.List;

import vn.anhtcn.lab.BookManagement.book.model.Book;

public interface BookRepositories {
	public void create(Book book);

	public void update(Book book);

	public void delete(int id);

	public List<Book> findAll();

	public List<Book> findAll(int start, int length);

	public int countAllBook();

	public Book findOne(int id);
}
