package com.rss.exceptions;

public class InvalidSessionException extends Exception {
    public InvalidSessionException() {
    }

    public InvalidSessionException(String message) {
        super(message);
    }
}
