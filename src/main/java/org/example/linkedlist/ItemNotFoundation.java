package org.example.linkedlist;

public class ItemNotFoundation extends RuntimeException {
    public ItemNotFoundation() {
    }

    public ItemNotFoundation(String message) {
        super(message);
    }

    public ItemNotFoundation(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemNotFoundation(Throwable cause) {
        super(cause);
    }

    public ItemNotFoundation(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
