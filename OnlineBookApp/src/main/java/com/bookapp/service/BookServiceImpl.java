package com.bookapp.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.bookapp.dao.IBookDAO;
import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBookService {

	private IBookDAO bookDao;
	@Autowired
	public void setBookDao(IBookDAO bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public void addBook(Book book) {
		bookDao.addBook(book);
	}

	@Override
	public void updateBook(int bookId, double price) {
		bookDao.updateBook(bookId, price);
	}

	@Override
	public boolean deleteBook(int bookId) {
		bookDao.deleteBook(bookId);
		return false;
	}

	@Override
	public Book getById(int bookId) throws IdNotFoundException {
		Book book=bookDao.findById(bookId);
		if(book==null)
			throw new IdNotFoundException("Invalid id");
		return book;
	}

	@Override
	public List<Book> getAll() throws IdNotFoundException {
		List<Book> booklist=bookDao.findAll();
		
		return booklist.stream().sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
	}

	@Override
	public List<Book> getByAuthor(String author) throws BookNotFoundException {
		List<Book> booksByAuthor=bookDao.findByAuthor(author);
		if(booksByAuthor.isEmpty())
			throw new BookNotFoundException("Books by this author "+author+" not found.");
		return booksByAuthor.stream().sorted((book1,book2)->book1.getTitle().compareTo(book2.getTitle())).collect(Collectors.toList());
		
	}

	@Override
	public List<Book> getByCategory(String category) throws BookNotFoundException {
		List<Book> booksByCategory=bookDao.findByCategory(category);
		if(booksByCategory.isEmpty())
			throw new BookNotFoundException("Books by this category "+category+" not found.");
		return booksByCategory.stream().sorted((book1,book2)->book1.getTitle().compareTo(book2.getTitle())).collect(Collectors.toList());
	}

	@Override
	public List<Book> getByLesserPrice(double price) throws BookNotFoundException {
		List<Book> booksByPrice=bookDao.findByLesserPrice(price);
		if(booksByPrice.isEmpty())
			throw new BookNotFoundException("Books by this price range "+price+" is not found.");
		return booksByPrice.stream().sorted((book1,book2)->book1.getTitle().compareTo(book2.getTitle())).collect(Collectors.toList());
	}

}
