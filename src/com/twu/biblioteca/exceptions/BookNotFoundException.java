package com.twu.biblioteca.exceptions;

/**
 * Created by ibarros on 6/13/16.
 */
public class BookNotFoundException extends Exception {
    public BookNotFoundException(String message) {
        super(message);
    }
}
