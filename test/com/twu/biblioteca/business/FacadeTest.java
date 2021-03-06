package com.twu.biblioteca.business;

import com.twu.biblioteca.exceptions.BookNotFoundException;
import com.twu.biblioteca.exceptions.MovieNotFoundException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static org.junit.Assert.assertEquals;

/**
 * Created by ibarros on 6/14/16.
 */
public class FacadeTest {
    @Test
    public void testFindAvailableBooks() throws BookNotFoundException {
        Facade facade = facade();
        facade.checkoutBook("Test-Driven Development by Example");
        List<Book> books = facade.findAvailableBooks();

        assertEquals(2, books.size());
        assertEquals("Java Head First", books.get(0).getTitle());
        assertEquals("The Agile Samurai", books.get(1).getTitle());
    }

    @Test
    public void testFindAvailableMovies() throws MovieNotFoundException {
        Facade facade = facade();
        facade.checkoutMovie("Persona");
        List<Movie> movies = facade.findAvailableMovies();

        assertEquals(2, movies.size());
        assertEquals("The Birds", movies.get(0).getTitle());
        assertEquals("Aquarius", movies.get(1).getTitle());
    }

    private Facade facade() {
        return new Facade(new Data());
    }
}
