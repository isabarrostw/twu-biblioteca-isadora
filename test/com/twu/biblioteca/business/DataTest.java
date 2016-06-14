package com.twu.biblioteca.business;

import com.twu.biblioteca.exceptions.BookNotFoundException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ibarros on 6/13/16.
 */
public class DataTest {
    @Test
    public void testFindBookIndex() throws BookNotFoundException {
        Data data = new Data();
        boolean isCheckedOut = false;
        int index = data.findBookIndex("The Agile Samurai", isCheckedOut);

        assertEquals(2, index);
    }
}
