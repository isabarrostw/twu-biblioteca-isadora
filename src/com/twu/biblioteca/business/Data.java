package com.twu.biblioteca.business;

import com.twu.biblioteca.exceptions.BookNotFoundException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by isa on 6/12/16.
 */
public class Data {
    private List<Book> books;

    public Data() {
        initializeBooks();
    }

    public List<Book> getBooks() {
        return books;
    }

    public int findBookIndex(String bookTitle, boolean checkedOut) throws BookNotFoundException {
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

    private void initializeBooks() {
        books = new ArrayList<Book>();
        books.add(new Book("Java Head First", "Bert Bates, Kathy Sierra", "2003"));
        books.add(new Book("Test-Driven Development by Example", "Kent Beck", "2003"));
        books.add(new Book("The Agile Samurai", "Jonathan Rasmusson", "2010"));
    }
}
