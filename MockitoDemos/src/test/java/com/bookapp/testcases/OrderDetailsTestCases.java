package com.bookapp.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.exceptipns.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import com.bookapp.service.OrderDetails;
@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class OrderDetailsTestCases {

	
	@Mock
	IBookService bookService;
	
	@InjectMocks
	OrderDetails details;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	Book book1, book2, book3, book4, book5;
	@BeforeEach
	void setUp() throws Exception {
		details = new OrderDetails();
		book1 = new Book(101, "Mahabharat", "Vyasa", 758.2);
		book2 = new Book(102, "Ramayan", "Valmiki", 957.5);
		book3 = new Book(103, "Crazy Maths", "Vyasa", 657.4);
		book4 = new Book(104, "Pyscho Physics", "S Chand", 654.25);
		book5 = new Book(105, "Mathematics Reference", "Vyasa", 981.23);
		details.setBookService(bookService);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Testing correct order")
	void testOrderBook() throws BookNotFoundException {
		int bookId=101;
		doReturn(book1).when(bookService).getById(bookId);
		String actualresult=details.orderBook(bookId);
		assertEquals("Ordered Successfully",actualresult);
	}
	
	@Test
	@DisplayName("Testing book returned as null")
	void testOrderBookNull() throws BookNotFoundException {
		int bookId=101;
		doReturn(null).when(bookService).getById(bookId);
		String actualresult=details.orderBook(bookId);
		assertEquals("Invalid Id-Book Not Ordered",actualresult);
	}
	
	@Test
	@DisplayName("Testing book return throw exception")
	void testOrderBookException() throws BookNotFoundException {
		int bookId=101;
		doThrow(new BookNotFoundException()).when(bookService).getById(bookId);
		String actualresult=details.orderBook(bookId);
		assertEquals("Technical issue-try again.",actualresult);
	}
	
	@Test
	@DisplayName("Testing add book with void type")
	void testAddBook() {
		doNothing().when(bookService).addBook(book1);
		String actual=details.addBook(book1);
		assertEquals("Book added",actual);
	}
	@Test
	@DisplayName("Testing add book with null")
	void testAddBookNull() {
		String actual=details.addBook(null);
		assertEquals("Book not added",actual);
	}
	
	
}
