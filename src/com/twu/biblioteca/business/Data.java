package com.twu.biblioteca.business;

import com.twu.biblioteca.exceptions.BookNotFoundException;

import java.util.Iterator;
import java.util.Vector;

import static java.util.Arrays.asList;

/**
 * Created by isa on 6/12/16.
 */
public class Data {
    private Vector<String> bookTableColumns;
    private Vector<Vector<String>> books;
    private Vector<Vector<String>> checkedOutBooks;

    public Data() {
        bookTableColumns = new Vector<String>();
        books = new Vector<Vector<String>>();
        checkedOutBooks = new Vector<Vector<String>>();
        initializeData();
    }

    public void initializeData() {
        bookTableColumns.addAll(asList("Title", "Author(s)", "Year"));

        String[][] bookList = {
                {"Java Head First", "Bert Bates, Kathy Sierra", "2003"},
                {"Test-Driven Development by Example", "Kent Beck", "2003"},
                {"The Agile Samurai", "Jonathan Rasmusson", "2010"}
        };

        for (int i = 0; i < bookList.length; i++) {
            Vector<String> tmp = new Vector<String>();
            tmp.addAll(asList(bookList[i]));
            books.add(tmp);
        }
    }

    public Vector<String> getBookTableColumns() {
        return bookTableColumns;
    }

    public Vector<Vector<String>> getBooks() {
        return books;
    }

    public Vector<Vector<String>> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    public void setBooks(Vector<Vector<String>> books) {
        this.books = books;
    }

    public void setCheckedOutBooks(Vector<Vector<String>> checkedOutBooks) {
        this.checkedOutBooks = checkedOutBooks;
    }

    public void checkoutBook(String bookName) throws BookNotFoundException {
        try {
            swapBookToVector(bookName, books, checkedOutBooks);
        } catch (BookNotFoundException e) {
            throw e;
        }
    }

    public void returnBook(String bookName) throws BookNotFoundException {
        try {
            swapBookToVector(bookName, books, checkedOutBooks);
        } catch (BookNotFoundException e) {
            throw e;
        }
    }

    private void swapBookToVector(String bookName, Vector<Vector<String>> originVector,
                                  Vector<Vector<String>> destinationVector) throws BookNotFoundException {
        Iterator<Vector<String>> iterator = originVector.iterator();

        boolean elementNotFound = true;
        Vector<String> bookToRemove = new Vector<String>();
        Vector<String> book;
        String title;
        while (iterator.hasNext() && elementNotFound) {
            book = iterator.next();
            title = book.get(0);

            if(title.equals(bookName)) {
                bookToRemove = book;
                destinationVector.add(bookToRemove);
                elementNotFound = false;
            }
        }

        if(elementNotFound) {
            throw new BookNotFoundException("Book not found");
        } else {
            originVector.remove(bookToRemove);
        }
    }
}
