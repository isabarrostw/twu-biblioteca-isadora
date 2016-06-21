package com.twu.biblioteca.business;

import com.twu.biblioteca.exceptions.BookNotFoundException;

/**
 * Created by ibarros on 6/13/16.
 */
public class Book implements Resource {
    private String title;
    private String author;
    private String year;
    private boolean checkedOut;

    public Book(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
        checkedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getYear() {
        return year;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void checkout() throws BookNotFoundException {
        if(!checkedOut) {
            checkedOut = true;
        } else {
            throw new BookNotFoundException("");
        }
    }

    public void returnToShelf() throws BookNotFoundException {
        if(checkedOut) {
            checkedOut = false;
        } else {
            throw new BookNotFoundException("");
        }
    }
}
