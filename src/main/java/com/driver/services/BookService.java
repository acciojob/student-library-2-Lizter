package com.driver.services;

import com.driver.models.Book;
import com.driver.repositories.AuthorRepository;
import com.driver.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {


    @Autowired
    BookRepository bookRepository2;
    @Autowired
    AuthorRepository authorRepository;

    public void createBook(Book book){

        bookRepository2.save(book);
    }

    public List<Book> getBooks(String genre, boolean available, String author){
        List<Book> books = null;
        //find the elements of the list by yourself
        List<Book>allbooks1=bookRepository2.findBooksByGenreAuthor(genre,null,true);
        List<Book>allbooks2=bookRepository2.findBooksByGenreAuthor(genre,author,false);

        allbooks1.addAll(allbooks2);
        return allbooks1;
    }
}
