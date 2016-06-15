package com.twu.biblioteca.business;

import com.twu.biblioteca.exceptions.BookNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by isa on 6/12/16.
 */
public class Data {
    private List<Book> books;

    public Data() {
        initializeBooks();
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Book> findAvailableBooks() {
        List<Book> availableBooks = new ArrayList<Book>();

        for (Book book: books) {
            if(!book.isCheckedOut()) {
                availableBooks.add(book);
            }
        }

        return availableBooks;
    }

    public Book findAvailableBook(String bookTitle) throws BookNotFoundException {
        Book book = findBook(bookTitle);

        if(!book.isCheckedOut()) {
            return book;
        } else {
            throw new BookNotFoundException("");
        }
    }

    public Book findCheckedOutBook(String bookTitle) throws BookNotFoundException {
        Book book = findBook(bookTitle);

        if(book.isCheckedOut()) {
            return book;
        } else {
            throw new BookNotFoundException("");
        }
    }

    private Book findBook(String bookTitle) throws BookNotFoundException {
        for (Book book: books) {
            if(book.getTitle().equals(bookTitle)) {
                return book;
            }
        }

        throw new BookNotFoundException("");
    }

    private void initializeBooks() {
        books = new ArrayList<Book>();
        books.add(new Book("Java Head First", "Bert Bates, Kathy Sierra", "2003"));
        books.add(new Book("Test-Driven Development by Example", "Kent Beck", "2003"));
        books.add(new Book("The Agile Samurai", "Jonathan Rasmusson", "2010"));
    }
}
