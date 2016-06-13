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
        assertEquals("Open Veins of Latin America", book.getTitle());
    }

    @Test
    public void testSetTitle() {
        Book book = new Book("Open Veins of Latin America", "Eduardo Galeano", "1971");
        book.setTitle("Soccer in Sun and Shadow");

        assertEquals("Soccer in Sun and Shadow", book.getTitle());
    }

    @Test
    public void testGetAuthor() {
        Book book = new Book("Open Veins of Latin America", "Eduardo Galeano", "1971");
        assertEquals("Eduardo Galeano", book.getAuthor());
    }

    @Test
    public void testSetAuthor() {
        Book book = new Book("Open Veins of Latin America", "Eduardo Galeano", "1971");
        book.setAuthor("Jose Saramago");

        assertEquals("Jose Saramago", book.getAuthor());
    }

    @Test
    public void testGetYear() {
        Book book = new Book("Open Veins of Latin America", "Eduardo Galeano", "1971");
        assertEquals("1971", book.getYear());
    }

    @Test
    public void testSetYear() {
        Book book = new Book("Open Veins of Latin America","Eduardo Galeano", "1971");
        book.setYear("2016");

        assertEquals("2016", book.getYear());
    }

    @Test
    public void testIsCheckedOut() {
        Book book = new Book("Open Veins of Latin America","Eduardo Galeano", "1971");
        assertEquals(false, book.isCheckedOut());
    }

    @Test
    public void testSetCheckedOut() {
        Book book = new Book("Open Veins of Latin America","Eduardo Galeano", "1971");
        book.setCheckedOut(true);

        assertEquals(true, book.isCheckedOut());
    }

    @Test
    public void testToVector() {
        Book book = new Book("Open Veins of Latin America","Eduardo Galeano", "1971");
        Vector<String> attributesVector = book.toVector();

        assertEquals("Open Veins of Latin America", attributesVector.get(0));
        assertEquals("Eduardo Galeano", attributesVector.get(1));
        assertEquals("1971", attributesVector.get(2));
    }
}
