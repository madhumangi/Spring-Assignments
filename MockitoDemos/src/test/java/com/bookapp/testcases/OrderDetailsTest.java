package com.bookapp.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.exceptipns.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import com.bookapp.service.OrderDetails;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)

class OrderDetailsTest {
	@InjectMocks
	OrderDetails orderDetails = null;

	@Mock
	IBookService bookService;// creating a proxy of BookService

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	Book book1, book2, book3, book4, book5;

	@BeforeEach
	void setUp() throws Exception {
		orderDetails = new OrderDetails();
		orderDetails.setBookService(bookService);
		book1 = new Book(101, "Mahabharat", "Vyasa", 758.2);
		book2 = new Book(102, "Ramayan", "Valmiki", 957.5);
		book3 = new Book(103, "Crazy Maths", "Vyasa", 657.4);
		book4 = new Book(104, "Pyscho Physics", "S Chand", 654.25);
		book5 = new Book(105, "Mathematics Reference", "Vyasa", 981.23);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Testing By id")
	void testBookByAuthor() throws BookNotFoundException{
		String author = "Vyasa";
		Mockito.when(bookService.getByAuthor(author)).thenReturn(Arrays.asList(book1, book3, book5));
		List<Book> books = orderDetails.findByAuthor(author);
		assertNotNull(books);
	}
	
	@Test
    @DisplayName("Testing By AUthor -  null")
    void testBookByAuthorNull() throws BookNotFoundException {
        String author = "Vyasa";
        when(bookService.getByAuthor(author)).thenReturn(null);
        List<Book> actualList = orderDetails.findByAuthor(author); // should be null
        assertNull(actualList);
    }

//	@Test
//	@DisplayName("Testing By Author-returning empty List")
//	void testBookByAuthorEmptyList() {
//		String author = "Vyasa";
//		when(bookService.getByAuthor(author)).thenReturn(null);
//		assertThrows(BookNotFoundException.class, () -> orderDetails.findByAuthor(author));
//
//	}
	@Test
    @DisplayName("Testing by author - sort by title")
    void testByAuthorSorted() throws BookNotFoundException {
        String author = "Vyasa";
        List<Book> expected = Arrays.asList(book3,book1, book5);// sorted books expected
        System.out.println("ex "+expected);
        when(bookService.getByAuthor(author)).thenReturn(Arrays.asList(book1,book3,book5));
        // method to be tested
        List<Book> actualList = orderDetails.findByAuthor(author);
        assertEquals(expected.toString(),actualList.toString());
    }
	
//	@Test
//	@DisplayName("Testing by author-sort by name")
//	void testByAuthorSorteyd() throws BookNotFoundException {
//		//method to be tested
//		String author="Vyasa";
//		List<Book> expectedresult=Arrays.asList(book3,book1,book5);
//		List<Book> actualresult=orderDetails.findByAuthor(author);
//		//System.out.println("ex"+expectedresult);
//		assertEquals(expectedresult.toString(),actualresult.toString());
//	}
	@Test
	@DisplayName("Testing author by empty list")
	void testByAuthorEmpty() throws BookNotFoundException{
		String author="Vyasa";
		when(bookService.getByAuthor(author)).thenReturn(new ArrayList<Book>());
		assertThrows(BookNotFoundException.class,()->orderDetails.findByAuthor(author));
	}
	
	@Test
	@DisplayName("TEsting by author-exception")
	void testByAuthorException() throws BookNotFoundException {
		String author="Vyasa";
		when(bookService.getByAuthor(author)).thenThrow(new BookNotFoundException());
		assertThrows(BookNotFoundException.class,()->orderDetails.findByAuthor(author));
	}
	@Test
	@DisplayName("Testing verify")
	void testVerify() throws BookNotFoundException {
		String author="Vyasa";
		List<Book> expected=Arrays.asList(book3,book1,book5);
		
		when(bookService.getByAuthor(author)).thenReturn(Arrays.asList(book1,book3,book5));
		List<Book> actualList=orderDetails.findByAuthor(author);
		assertEquals(expected.toString(),actualList.toString());
		assertNotNull(actualList);
		
		when(bookService.getByAuthor(author)).thenReturn(null);
		List<Book> actual=orderDetails.findByAuthor(author);
		assertNull(actual);
		
//		when(bookService.getByAuthor(author)).thenReturn(null);
//		List<Book> actualList=orderDetails.findByAuthor(author);
//		assertNull(actualList);
		
		Mockito.verify(bookService,times(2)).getByAuthor(author);
		Mockito.verify(bookService,atLeastOnce()).getByAuthor(author);
		Mockito.verify(bookService,atLeast(2)).getByAuthor(author);
	}
	

}
