package ru.yandex.practicum.catsgram.util;

public class UserAlreadyExistException extends Exception {

    public UserAlreadyExistException(final String message) {
        super(message);
    }
}

