package com.bookapp.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.bookapp.exceptipns.BookNotFoundException;
import com.bookapp.model.Book;

public class OrderDetails {
	IBookService bookService;
	
	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}
//	List<Book> books=null;
//	List<Book> books=new ArrayList<>();
	public List<Book> findByAuthor(String author) throws BookNotFoundException{
		List<Book> books=bookService.getByAuthor(author);
		if(books!=null) {
		if(books.isEmpty())
			throw new BookNotFoundException("author not found");
		return books.stream().sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
//		if(books==null)
//			throw new BookNotFoundException("author not found");
//		return books;
		}else
			return null;
	}
	
	public String orderBook(int bookId) throws BookNotFoundException{
		
		try {
			Book book = bookService.getById(bookId);
			
			
			if(book!=null)
				return "Ordered Successfully";
			else 
				return "Invalid Id-Book Not Ordered";
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			return "Technical issue-try again.";
		}
	
	public String addBook(Book book) {
		if(book==null)
			return "Book not added";
		bookService.addBook(book);
		return "Book added";
	}
}
