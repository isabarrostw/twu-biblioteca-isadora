package com.twu.biblioteca.business;

import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.assertEquals;

/**
 * Created by ibarros on 6/13/16.
 */
public class BookTest {
    @Test
    public void testGetTitle() {
        Book book = new Book("Open Veins of Latin America", "Eduardo Galeano", "1971");
        assertEquals(book.getTitle(), "Open Veins of Latin America");
    }

    @Test
    public void testSetTitle() {
        Book book = new Book("Open Veins of Latin America", "Eduardo Galeano", "1971");
        book.setTitle("Soccer in Sun and Shadow");

        assertEquals(book.getTitle(), "Soccer in Sun and Shadow");
    }

    @Test
    public void testGetAuthor() {
        Book book = new Book("Open Veins of Latin America", "Eduardo Galeano", "1971");
        assertEquals(book.getAuthor(), "Eduardo Galeano");
    }

    @Test
    public void testSetAuthor() {
        Book book = new Book("Open Veins of Latin America", "Eduardo Galeano", "1971");
        book.setAuthor("Jose Saramago");

        assertEquals(book.getAuthor(), "Jose Saramago");
    }

    @Test
    public void testGetYear() {
        Book book = new Book("Open Veins of Latin America", "Eduardo Galeano", "1971");
        assertEquals(book.getYear(), "1971");
    }

    @Test
    public void testSetYear() {
        Book book = new Book("Open Veins of Latin America","Eduardo Galeano", "1971");
        book.setYear("2016");

        assertEquals(book.getYear(), "2016");
    }

    @Test
    public void testIsCheckedOut() {
        Book book = new Book("Open Veins of Latin America","Eduardo Galeano", "1971");
        assertEquals(book.isCheckedOut(), false);
    }

    @Test
    public void testSetCheckedOut() {
        Book book = new Book("Open Veins of Latin America","Eduardo Galeano", "1971");
        book.setCheckedOut(true);

        assertEquals(book.isCheckedOut(), true);
    }

    @Test
    public void testBookAttributes() {
        Book book = new Book("Open Veins of Latin America","Eduardo Galeano", "1971");
        Vector<String> attributesVector = book.bookAttributes();

        assertEquals(attributesVector.get(0), "Open Veins of Latin America");
        assertEquals(attributesVector.get(1), "Eduardo Galeano");
        assertEquals(attributesVector.get(2), "1971");
    }
}
