package com.twu.biblioteca.business;

import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.assertEquals;

/**
 * Created by ibarros on 6/13/16.
 */
public class DataTest {
    @Test
    public void testGetNotCheckedOutBooksVector() {
        Vector<Book> books = new Data().getBooks();
        books.get(1).setCheckedOut(true);

        assertEquals(3, books.size());
        assertEquals(false, books.get(0).isCheckedOut());
        assertEquals(true, books.get(1).isCheckedOut());
        assertEquals(false, books.get(2).isCheckedOut());
    }
}
