package com.twu.biblioteca.business;

import com.twu.biblioteca.exceptions.BookNotFoundException;
import com.twu.biblioteca.exceptions.MovieNotFoundException;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by ibarros on 6/13/16.
 */
public class DataTest {
    @Test
    public void testFindBookWhenBookExists() throws BookNotFoundException {
        Data data = new Data();
        Book book = data.findBook("The Agile Samurai");

        assertEquals("The Agile Samurai", book.getTitle());
    }

    @Test(expected = BookNotFoundException.class)
    public void testFindBookWhenBookDoesNotExist() throws BookNotFoundException {
        Data data = new Data();
        data.findBook("Open Veins of Latin America");
    }

    @Test
    public void testFindMovieWhenMovieExists() throws MovieNotFoundException {
        Data data = new Data();
        Movie movie = data.findMovie("Persona");

        assertEquals("Persona", movie.getTitle());
    }

    @Test(expected = MovieNotFoundException.class)
    public void testFindMovieWhenMovieDoesNotExist() throws MovieNotFoundException {
        Data data = new Data();
        data.findMovie("The Good, The Bad and The Ugly");
    }
}
