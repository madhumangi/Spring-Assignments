package com.example.controller;

import com.example.model.Book;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private IBookService bookService;

    //  http://localhost:8080/books
    @GetMapping("/books")
    public List<Book> showBooks(){
        return bookService.getAll();
    }
    //  http://localhost:8080/books/authod/RD_Sharma
    @GetMapping("/books/author/{myauthor}")
    public List<Book> showByAuthor(@PathVariable("myauthor") String author){
        return bookService.getByAuthor(author);
    }

    // http://localhost:8080/books/category?mycategory=Mythology --assuming this comes from a form
    @GetMapping("/books/category")
    public List<Book> showByCategory(@RequestParam("mycategory")String category){
        return bookService.getByCategory(category);
    }

    //  http://localhost:8080/books/price/500
    @GetMapping("/books/price/{price}")
    public List<Book> showByLssPrice(@PathVariable("price") double price){
        return bookService.getByLesserPrice(price);
    }

    //  http://localhost:8080/books/id/1
    @GetMapping("/books/id/{bookId}")
    public Book showByBookID(@PathVariable("bookId") int bookId){
        return bookService.getById(bookId);
    }


}
