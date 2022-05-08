package com.bookapp.main;

import java.util.Scanner;

import com.bookapp.dao.BookDAOImpl;
import com.bookapp.dao.IBookDAO;
import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImpl;
import com.bookapp.service.IBookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookMain {

	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext("com.bookapp");
		IBookService bookservice=context.getBean("bookServiceImpl",BookServiceImpl.class);
		String admin="Madhu";
		String username;
		String password="abcd1234";
		String pwd;
		int choice;
		int select;
		int bookid;
		String title;
		String author;
		String category;
		double price;
		//IBookService bookservice=new BookServiceImpl();
		//Book book=new Book("Mathematics","RS Aggarwal","School",550);
		//bookservice.addBook(book);
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Select from below:\n \t1.Admin\n\t2.User");
		select=sc.nextInt();
		if(select==1) {
			System.out.println("Enter username:");
			username=sc.next();
			System.out.println("Enter password:");
			pwd=sc.next();
			if(username.equalsIgnoreCase(admin) && pwd.equalsIgnoreCase(password))
			do {
				System.out.println("Select from below options:\n\t\t1.Add Book.\n\t\t2.Update Book.\n\t\t3.Delete Book.\n\t\t4.Find book by book id.\n\t\t5.Exit");
				choice=sc.nextInt();
				switch(choice) {
				case 1:
					Book book=null;
					sc.nextLine();
					System.out.println("Enter the title of the book:");
					title=sc.nextLine();
					System.out.println("Enter the author of the book:");
					author=sc.nextLine();
					System.out.println("Enter the category of the book:");
					category=sc.nextLine();
					System.out.println("Enter the price of the book:");
					price=sc.nextDouble();
					book=new Book(title,author,category,price);
					bookservice.addBook(book);
					
					break;
				case 2:
					System.out.println("Enter the book id:");
					bookid=sc.nextInt();
					System.out.println("Enter the price of the book:");
					price=sc.nextDouble();
					bookservice.updateBook(bookid, price);
					break;
				case 3:
					System.out.println("Enter the book id:");
					bookid=sc.nextInt();
					System.out.println(bookservice.deleteBook(bookid));;
					break;
				case 4:
					System.out.println("Enter the book id:");
					bookid=sc.nextInt();
					try {
						System.out.println(bookservice.getById(bookid));;
					} catch (IdNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 5:
					System.out.println("THANK YOU.");
					continue;
				default:
					System.out.println("Wrong Choice.");
					break;
				}
			}while(choice!=5);
			else
				System.out.println("Wrong username or passwrod");
		}
		else {
			do {
				System.out.println("Select from below options:\n\t\t1.Get all books.\n\t\t2.Find book by author.\n\t\t3.Find book by category.\n\t\t4.Find book by price.\n\t\t5.Exit");
				choice=sc.nextInt();
				switch(choice) {
				case 1:
					try {
						System.out.println(bookservice.getAll());
					} catch (IdNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 2:
					System.out.println("Enter the author of the book:");
					sc.nextLine();
					author=sc.nextLine();
					try {
						System.out.println(bookservice.getByAuthor(author));
					} catch (BookNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 3:
					System.out.println("Enter the category of the book:");
					sc.nextLine();
					category=sc.nextLine();
					try {
						System.out.println(bookservice.getByCategory(category));
					} catch (BookNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 4:
					System.out.println("Enter the price of the book:");
					price=sc.nextInt();
					try {
						System.out.println(bookservice.getByLesserPrice(price));
					} catch (BookNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 5:
					System.out.println("THANK YOU.");
					continue;
				default:
					System.out.println("Wrong choice");
					break;
				}
			}while(choice!=5);
		}
		sc.close();
	}
	
}
