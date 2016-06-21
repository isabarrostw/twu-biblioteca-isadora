package com.twu.biblioteca.business;

import com.twu.biblioteca.exceptions.MovieNotFoundException;

/**
 * Created by ibarros on 6/14/16.
 */
public class Movie implements Resource{
    private String title;
    private String year;
    private String director;
    private int rating;
    private boolean checkedOut;

    public Movie(String title, String director, String year, int rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        checkedOut = false;
    }

    public String getTitle() {
        return title;
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

    public void checkout() throws MovieNotFoundException {
        if(!checkedOut) {
            checkedOut = true;
        } else {
            throw new MovieNotFoundException("");
        }
    }
}
