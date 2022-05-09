package com.example.service;

import com.example.exceptions.BookNotFoundException;
import com.example.model.Book;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class BookServiceImpl implements IBookService{

    private List<Book> showBooks(){
        return Arrays.asList(
                new Book(1,"Java","S Chand","Tech",750),
                new Book(2,"Mathematics","RD Sharma","Science",550),
                new Book(3,"Maths","RS Aggarwal","Science",375),
                new Book(4,"Half Girlfriend","Chetan Bhagat","Fiction",374),
                new Book(5,"Mahabharata","Vyasa","Mythology",980)
                );

    }

    @Override
    public Book getById(int bookId) throws BookNotFoundException {
        return showBooks().stream()
                .filter((book1)->book1.getBookId()==bookId).findFirst()
                .orElseThrow(()->new BookNotFoundException("Book Id not found"));
    }

    @Override
    public List<Book> getAll() {
        return showBooks();
    }

    @Override
    public List<Book> getByAuthor(String author) throws BookNotFoundException {
        List<Book> books=showBooks().stream()
                .filter((book)->book.getAuthor().equalsIgnoreCase(author))
                .sorted(Comparator.comparing(Book::getBookId))
                .collect(Collectors.toList());
        if(books.isEmpty())
            throw new BookNotFoundException("Author not found");
        else
            return books;
    }

    @Override
    public List<Book> getByCategory(String category) throws BookNotFoundException {
        List<Book> books=showBooks().stream()
                .filter((book)->book.getCategory().equalsIgnoreCase(category))
                .sorted(Comparator.comparing(Book::getCategory))
                .collect(Collectors.toList());
        if(books.isEmpty())
            throw new BookNotFoundException("Category not found");
        else
            return books;
    }

    @Override
    public List<Book> getByLesserPrice(double price) throws BookNotFoundException {
        List<Book> books=showBooks().stream()
                .filter((book)->book.getPrice()<price)
                .sorted(Comparator.comparing(Book::getPrice))
                .collect(Collectors.toList());
        if(books.isEmpty())
            throw new BookNotFoundException("Book not found");
        else
            return books;
    }
}
