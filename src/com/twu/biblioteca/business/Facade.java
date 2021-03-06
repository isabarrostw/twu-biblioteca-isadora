package com.twu.biblioteca.business;

import com.twu.biblioteca.exceptions.BookNotFoundException;
import com.twu.biblioteca.exceptions.MovieNotFoundException;

import java.util.List;

/**
 * Created by ibarros on 6/14/16.
 */
public class Facade {
    private Data data;

    public Facade(Data data) {
        this.data = data;
    }

    public List<Book> findAvailableBooks() {
        return data.findAvailableBooks();
    }

    public void checkoutBook(String bookTitle) throws BookNotFoundException {
        data.findBook(bookTitle).checkout();
    }

    public void returnBook(String bookTitle) throws BookNotFoundException {
        data.findBook(bookTitle).returnToShelf();
    }

    public List<Movie> findAvailableMovies() {
        return data.findAvailableMovies();
    }

    public void checkoutMovie(String movieName) throws MovieNotFoundException {
        data.findMovie(movieName).checkout();
    }
}
