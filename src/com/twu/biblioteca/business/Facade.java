package com.twu.biblioteca.business;

import com.twu.biblioteca.exceptions.BookNotFoundException;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by ibarros on 6/14/16.
 */
public class Facade {
    private Data data;

    public Facade(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public Vector<Vector<String>> getNotCheckedOutBooksVector() {
        Vector<Vector<String>> resultVector = new Vector<Vector<String>>();

        Iterator<Book> iterator = data.getBooks().iterator();
        Book book;
        while (iterator.hasNext()) {
            book = iterator.next();

            if (!book.isCheckedOut()) {
                resultVector.add(book.toVector());
            }
        }

        return resultVector;
    }

    public void checkoutBook(String bookName) throws BookNotFoundException {
        int index = data.findBookIndex(bookName, false);
        data.getBooks().get(index).setCheckedOut(true);
    }

    public void returnBook(String bookName) throws BookNotFoundException {
        int index = data.findBookIndex(bookName, true);
        data.getBooks().get(index).setCheckedOut(false);
    }
}
