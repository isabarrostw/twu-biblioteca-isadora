package com.twu.biblioteca.business;

import com.twu.biblioteca.exceptions.BookNotFoundException;
import com.twu.biblioteca.exceptions.MovieNotFoundException;
import com.twu.biblioteca.exceptions.ResourceNotFoundException;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by isa on 6/12/16.
 */
public class Data {
    private List<Resource> books;
    private List<Resource> movies;

    public Data() {
        initializeBooks();
        initializeMovies();
    }

    public List<Book> findAvailableBooks() {
        return (List<Book>)(List<? extends Resource>) findResourceByAvailability(true, books);
    }

    public List<Movie> findAvailableMovies() {
        return (List<Movie>)(List<? extends Resource>) findResourceByAvailability(true, movies);
    }

    public Book findBook(String title) throws BookNotFoundException {
        try {
            return (Book) findResource(title, books);
        } catch (ResourceNotFoundException e) {
            throw new BookNotFoundException("");
        }
    }

    public Movie findMovie(String title) throws MovieNotFoundException {
        try {
            return (Movie) findResource(title, movies);
        } catch (ResourceNotFoundException e) {
            throw new MovieNotFoundException("");
        }
    }

    private Resource findResource(String title, List<Resource> resourceList) throws ResourceNotFoundException {
        for (Resource resource: resourceList) {
            if(resource.getTitle().equals(title)) {
                return resource;
            }
        }

        throw new ResourceNotFoundException("");
    }

    private List<Resource> findResourceByAvailability(boolean isAvailable, List<Resource> resourceList) {
        List<Resource> filteredResources  = new ArrayList<Resource>();

        for (Resource resource: resourceList) {
            if(!resource.isCheckedOut() == isAvailable) {
                filteredResources.add(resource);
            }
        }

        return filteredResources;
    }

    private void initializeBooks() {
        books = new ArrayList<Resource>();
        books.add(new Book("Java Head First", "Bert Bates, Kathy Sierra", "2003"));
        books.add(new Book("Test-Driven Development by Example", "Kent Beck", "2003"));
        books.add(new Book("The Agile Samurai", "Jonathan Rasmusson", "2010"));
    }

    private void initializeMovies() {
        movies = new ArrayList<Resource>();
        movies.add(new Movie("The Birds", "Alfred Hitchcock", "1963", 9));
        movies.add(new Movie("Persona", "Ingmar Bergman", "1966", 9));
        movies.add(new Movie("Aquarius", "Kleber Mendonca", "2016", 8));
    }
}
