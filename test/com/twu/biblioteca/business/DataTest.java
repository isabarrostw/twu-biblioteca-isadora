package com.twu.biblioteca.business;

import com.twu.biblioteca.exceptions.BookNotFoundException;
import com.twu.biblioteca.exceptions.MovieNotFoundException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by ibarros on 6/13/16.
 */
public class DataTest {
    @Test
    public void testFindAvailableBook() throws BookNotFoundException {
        Book book = new Data().findAvailableBook("The Agile Samurai");
        assertEquals("The Agile Samurai", book.getTitle());
    }

    @Test
    public void testFindCheckedOutBook() throws BookNotFoundException {
        Data data = new Data();
        data.findAvailableBook("The Agile Samurai").checkout();

        Book book = data.findCheckedOutBook("The Agile Samurai");
        assertEquals("The Agile Samurai", book.getTitle());
    }

    @Test
    public void testFindAvailableBooks() throws BookNotFoundException {
        Data data = new Data();
        data.getBooks().get(1).checkout();

        List<Book> books = data.findAvailableBooks();

        assertEquals(2, books.size());
        assertEquals("Java Head First", books.get(0).getTitle());
        assertEquals("The Agile Samurai", books.get(1).getTitle());
    }

    @Test
    public void testFindAvailableMovies() {
        Data data = new Data();
        data.getMovies().get(1).checkout();

        List<Movie> movies = data.findAvailableMovies();

        assertEquals(2, movies.size());
        assertEquals("The Birds", movies.get(0).getName());
        assertEquals("Aquarius", movies.get(1).getName());
    }
}
