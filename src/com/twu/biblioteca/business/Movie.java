package com.twu.biblioteca.business;

/**
 * Created by ibarros on 6/14/16.
 */
public class Movie {
    private String name;
    private String year;
    private String director;
    private int rating;
    private boolean checkedOut;

    public Movie(String name, String director, String year, int rating) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
        checkedOut = false;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public int getRating() {
        return rating;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void checkout() {
        checkedOut = true;
    }
}
