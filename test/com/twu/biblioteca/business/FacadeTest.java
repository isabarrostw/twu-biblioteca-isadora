package com.twu.biblioteca.business;

import com.twu.biblioteca.exceptions.BookNotFoundException;
import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.assertEquals;

/**
 * Created by ibarros on 6/14/16.
 */
public class FacadeTest {
    @Test
    public void testGetNotCheckedOutBooksVector() {
        Facade facade = facade();
        facade.getData().getBooks().set(1, new Book("Open Veins of Latin America", "Eduardo Galeano", "1971", true));
        Vector<Vector<String>> books = facade.getNotCheckedOutBooksVector();

        assertEquals(2, books.size());
        assertEquals("Java Head First", books.get(0).get(0));
        assertEquals("The Agile Samurai", books.get(1).get(0));
    }

    @Test
    public void testCheckoutBook() throws BookNotFoundException {
        Facade facade = facade();
        facade.checkoutBook("Test-Driven Development by Example");

        assertEquals(true, facade.getData().getBooks().get(1).isCheckedOut());
    }

    @Test
    public void testReturnBook() throws BookNotFoundException {
        Facade facade = facade();
        facade.checkoutBook("Test-Driven Development by Example");
        facade.returnBook("Test-Driven Development by Example");

        assertEquals(false, facade.getData().getBooks().get(1).isCheckedOut());
    }

    private Facade facade() {
        return new Facade(new Data());
    }
}
