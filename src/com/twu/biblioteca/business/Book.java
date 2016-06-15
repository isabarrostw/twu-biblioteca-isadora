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

    public Book(String title, String author, String year, boolean checkedOut) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.checkedOut = checkedOut;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public Vector<String> toVector() {
        Vector<String> attributesVector = new Vector<String>();

        attributesVector.add(title);
        attributesVector.add(author);
        attributesVector.add(year);

        return attributesVector;
    }
}
