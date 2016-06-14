package com.twu.biblioteca.business;

import com.twu.biblioteca.exceptions.BookNotFoundException;

import java.util.Iterator;
import java.util.Vector;

import static java.util.Arrays.asList;

/**
 * Created by isa on 6/12/16.
 */
public class Data {
    private Vector<String> bookTableColumns;
    private Vector<String> movieTableColumns;
    private Vector<Book> books;
    private Vector<Movie> movies;

    public Data() {
        initializeBooks();
        initializeMovies();
    }

    public Vector<Book> getBooks() {
        return books;
    }

    public Vector<String> getBookTableColumns() {
        return bookTableColumns;
    }

    public int findBookIndex(String bookTitle, boolean checkedOut) throws BookNotFoundException {
        Iterator<Book> iterator = books.iterator();

        boolean bookFound = false;
        Book currentBook;
        String currentTitle;
        int currentIndex = 0;
        int returnIndex = 0;

        while (iterator.hasNext()) {
            currentBook = iterator.next();
            currentTitle = currentBook.getTitle();

            if(currentTitle.equals(bookTitle) && currentBook.isCheckedOut() == checkedOut) {
                bookFound = true;
                returnIndex = currentIndex;
            }

            currentIndex++;
        }

        if(bookFound) {
            return returnIndex;
        } else {
            throw new BookNotFoundException("");
        }
    }

    private void initializeBooks() {
        bookTableColumns = new Vector<String>();
        bookTableColumns.addAll(asList("Title", "Author(s)", "Year"));

        books = new Vector<Book>();
        books.add(new Book("Java Head First", "Bert Bates, Kathy Sierra", "2003"));
        books.add(new Book("Test-Driven Development by Example", "Kent Beck", "2003"));
        books.add(new Book("The Agile Samurai", "Jonathan Rasmusson", "2010"));
    }

    private void initializeMovies() {
        movieTableColumns = new Vector<String>();
        movieTableColumns.addAll(asList("Name", "Director(s)", "Year"));

        movies.add(new Movie("The Birds", "Alfred Hitchcock", "1963", 9));
        movies.add(new Movie("Persona", "Ingmar Bergman", "1966", 9));
        movies.add(new Movie("Aquarius", "Kleber Mendonca", "2016", 8));
    }
}
