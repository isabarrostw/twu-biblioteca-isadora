package com.twu.biblioteca.business;

import com.twu.biblioteca.exceptions.BookNotFoundException;
import com.twu.biblioteca.exceptions.MovieNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by isa on 6/12/16.
 */
public class Data {
    private List<Book> books;
    private List<Movie> movies;

    public Data() {
        initializeBooks();
        initializeMovies();
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Movie> getMovies() {
        return movies;
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

    public List<Movie> findAvailableMovies() {
        List<Movie> availableMovies = new ArrayList<Movie>();

        for (Movie movie: movies) {
            if(!movie.isCheckedOut()) {
                availableMovies.add(movie);
            }
        }

        return availableMovies;
    }

    public Movie findAvailableMovie(String movieName) throws MovieNotFoundException {
        Movie movie = findMovie(movieName);

        if(!movie.isCheckedOut()) {
            return movie;
        } else {
            throw new MovieNotFoundException("");
        }
    }

    private Movie findMovie(String movieName) throws MovieNotFoundException {
        for (Movie movie: movies) {
            if(movie.getName().equals(movieName)) {
                return movie;
            }
        }

        throw new MovieNotFoundException("");
    }

    private void initializeBooks() {
        books = new ArrayList<Book>();
        books.add(new Book("Java Head First", "Bert Bates, Kathy Sierra", "2003"));
        books.add(new Book("Test-Driven Development by Example", "Kent Beck", "2003"));
        books.add(new Book("The Agile Samurai", "Jonathan Rasmusson", "2010"));
    }

    private void initializeMovies() {
        movies = new ArrayList<Movie>();
        movies.add(new Movie("The Birds", "Alfred Hitchcock", "1963", 9));
        movies.add(new Movie("Persona", "Ingmar Bergman", "1966", 9));
        movies.add(new Movie("Aquarius", "Kleber Mendonca", "2016", 8));
    }
}
