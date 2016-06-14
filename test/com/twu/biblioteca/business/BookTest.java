package com.twu.biblioteca.business;

import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.assertEquals;

/**
 * Created by ibarros on 6/13/16.
 */
public class BookTest {
    @Test
    public void testToVector() {
        Book book = new Book("Open Veins of Latin America","Eduardo Galeano", "1971");
        Vector<String> attributesVector = book.toVector();

        assertEquals("Open Veins of Latin America", attributesVector.get(0));
        assertEquals("Eduardo Galeano", attributesVector.get(1));
        assertEquals("1971", attributesVector.get(2));
    }
}
