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
    private Vector<Book> books;

    public Data() {
        bookTableColumns = new Vector<String>();
        books = new Vector<Book>();
        initializeData();
    }

    public void initializeData() {
        bookTableColumns.addAll(asList("Title", "Author(s)", "Year"));
        books.add(new Book("Java Head First", "Bert Bates, Kathy Sierra", "2003"));
        books.add(new Book("Test-Driven Development by Example", "Kent Beck", "2003"));
        books.add(new Book("The Agile Samurai", "Jonathan Rasmusson", "2010"));
    }

    public Vector<Book> getBooks() {
        return books;
    }

    public Vector<String> getBookTableColumns() {
        return bookTableColumns;
    }

    public Vector<Vector<String>> getNotCheckedOutBooksVector() {
        Vector<Vector<String>> resultVector = new Vector<Vector<String>>();

        Iterator<Book> iterator = books.iterator();
        Book book;
        while(iterator.hasNext()) {
            book = iterator.next();

            if(!book.isCheckedOut()) {
                resultVector.add(book.toVector());
            }
        }

        return resultVector;
    }

    public void checkoutBook(String bookName) throws BookNotFoundException {
        try {
            int index = findBookIndex(bookName, false);
            books.get(index).setCheckedOut(true);
        } catch (BookNotFoundException e) {
            throw e;
        }
    }

    public void returnBook(String bookName) throws BookNotFoundException {
        try {
            int index = findBookIndex(bookName, true);
            books.get(index).setCheckedOut(false);
        } catch (BookNotFoundException e) {
            throw e;
        }
    }

    private int findBookIndex(String bookTitle, boolean checkedOut) throws BookNotFoundException {
        Iterator<Book> iterator = books.iterator();

        boolean bookFound = false;
        Book currentBook;
        String currentTitle;
        int currentIndex = 0;
        int returnIndex = 0;

        while (iterator.hasNext()) {
            currentBook = iterator.next();
            currentTitle = currentBook.getTitle();

            if(currentTitle.equals(bookTitle) && currentBook.isCheckedOut() == checkedOut) {
                bookFound = true;
                returnIndex = currentIndex;
            }

            currentIndex++;
        }

        if(bookFound) {
            return returnIndex;
        } else {
            throw new BookNotFoundException("");
        }
    }
}
