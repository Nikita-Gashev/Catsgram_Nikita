package ru.yandex.practicum.catsgram.util;

public class InvalidEmailException extends Exception {

    public InvalidEmailException(final String message) {
        super(message);
    }
}
