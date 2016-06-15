package com.twu.biblioteca.business;

import java.util.Vector;

/**
 * Created by ibarros on 6/13/16.
 */
public class Book {
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

    public void checkout() {
        checkedOut = true;
    }

    public void returnToShelf() {
        checkedOut = false;
    }
}
