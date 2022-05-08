package com.bookapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookapp.model.Book;
import com.bookapp.util.AllQueries;
import com.bookapp.util.ConnectionUtil;

import org.springframework.stereotype.Component;

@Component
public class BookDAOImpl implements IBookDAO{
	private static Connection connection;
	@Override
	public void addBook(Book book) {
		connection=ConnectionUtil.openConnection();
		PreparedStatement preparedstatement=null;
		try {
			preparedstatement=connection.prepareStatement(AllQueries.INSERTQUERY);
			preparedstatement.setString(1, book.getTitle());
			preparedstatement.setString(2,book.getAuthor());
			preparedstatement.setString(3,book.getCategory());
			preparedstatement.setDouble(4,book.getPrice());
			preparedstatement.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(preparedstatement!=null)
				try {
					preparedstatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ConnectionUtil.closeConnection();
		}
		System.out.println("Book added successfully");
	}

	@Override
	public void updateBook(int bookId, double price) {
		connection=ConnectionUtil.openConnection();
		PreparedStatement preparedstatement=null;
		try {
			preparedstatement=connection.prepareStatement(AllQueries.UPDATEQUERY);
			preparedstatement.setDouble(1,price);
			preparedstatement.setInt(2, bookId);
			preparedstatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(preparedstatement!=null)
				try {
					preparedstatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ConnectionUtil.closeConnection();
		}
		System.out.println("Updated successfully");
	}

	@Override
	public void deleteBook(int bookId) {
		connection=ConnectionUtil.openConnection();
		PreparedStatement preparedstatement=null;
		try {
			preparedstatement=connection.prepareStatement(AllQueries.DELETEQUERY);
			preparedstatement.setInt(1, bookId);
			preparedstatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(preparedstatement!=null)
				try {
					preparedstatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ConnectionUtil.closeConnection();
		}
		System.out.println("Deleted successfully.");
	}

	@Override
	public Book findById(int bookId) {
		connection=ConnectionUtil.openConnection();
		PreparedStatement preparedstatement=null;
		Book book=null;
		try {
			preparedstatement=connection.prepareStatement(AllQueries.SELECTONEQUERY);
			preparedstatement.setInt(1, bookId);
			ResultSet rs=preparedstatement.executeQuery();
			while(rs.next()) {
				String title=rs.getString("title");
				String author=rs.getString("author");
				String category=rs.getString("category");
				double price=rs.getDouble("price");
				book=new Book(bookId,title,author,category,price);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(preparedstatement!=null)
				try {
					preparedstatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ConnectionUtil.closeConnection();
		}		return book;
	}

	@Override
	public List<Book> findAll() {
		connection=ConnectionUtil.openConnection();
		PreparedStatement preparedstatement=null;
		Book book=null;
		List<Book> bookList=new ArrayList<Book>();
		try {
			preparedstatement=connection.prepareStatement(AllQueries.SELECTQUERY);
			ResultSet rs=preparedstatement.executeQuery();
			
			while(rs.next()) {
				String title=rs.getString("title");
				String author=rs.getString("author");
				String category=rs.getString("category");
				double price=rs.getDouble("price");
				int bookid=rs.getInt("bookid");
				book=new Book(bookid,title,author,category,price);
				bookList.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bookList;
	}

	@Override
	public List<Book> findByAuthor(String author) {
		connection=ConnectionUtil.openConnection();
		PreparedStatement preparedstatement=null;
		Book book=null;
		List<Book> bookList=new ArrayList<Book>();
		try {
			preparedstatement=connection.prepareStatement(AllQueries.AUTHORQUERY);
			preparedstatement.setString(1, author);
			ResultSet rs=preparedstatement.executeQuery();
			while(rs.next()) {
				String title=rs.getString("title");
				String category=rs.getString("category");
				double price=rs.getDouble("price");
				int bookid=rs.getInt("bookid");
				book=new Book(bookid,title,author,category,price);
				bookList.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bookList;
	}

	@Override
	public List<Book> findByCategory(String category) {
		connection=ConnectionUtil.openConnection();
		PreparedStatement preparedstatement=null;
		Book book=null;
		List<Book> bookList=new ArrayList<Book>();
		try {
			preparedstatement=connection.prepareStatement(AllQueries.CAQUERY);
			preparedstatement.setString(1, category);
			
			ResultSet rs=preparedstatement.executeQuery();
			while(rs.next()) {
				String title=rs.getString("title");
				String author=rs.getString("author");
				double price=rs.getDouble("price");
				int bookid=rs.getInt("bookid");
				book=new Book(bookid,title,author,category,price);
				bookList.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bookList;
	}

	@Override
	public List<Book> findByLesserPrice(double price) {
		connection=ConnectionUtil.openConnection();
		PreparedStatement preparedstatement=null;
		Book book=null;
		List<Book> bookList=new ArrayList<Book>();
		try {
			preparedstatement=connection.prepareStatement(AllQueries.PRICEQUERY);
			preparedstatement.setDouble(1, price);
			ResultSet rs=preparedstatement.executeQuery();
			while(rs.next()) {
				String title=rs.getString("title");
				String category=rs.getString("category");
				String author=rs.getString("author");
				int bookid=rs.getInt("bookid");
				double rate=rs.getInt("price");
				book=new Book(bookid,title,author,category,rate);
				bookList.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bookList;
	}

}
