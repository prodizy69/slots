package com.rss.exceptions;

public class UniqueKeyException extends Exception {
    public UniqueKeyException() {
    }

    public UniqueKeyException(String message) {
        super(message);
    }
}
