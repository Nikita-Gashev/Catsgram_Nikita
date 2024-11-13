package ru.yandex.practicum.catsgram.controller;

import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.model.Post;
import ru.yandex.practicum.catsgram.model.User;
import ru.yandex.practicum.catsgram.util.InvalidEmailException;
import ru.yandex.practicum.catsgram.util.UserAlreadyExistException;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private final Map<String, User> users = new HashMap<>();

    @GetMapping
    public Map<String, User> findAll() {
        return users;
    }

    @PostMapping
    public void create(@RequestBody User user) throws UserAlreadyExistException, InvalidEmailException {
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new InvalidEmailException("Некорректный email");
        } else if (users.containsKey(user.getEmail())) {
            throw new UserAlreadyExistException("Пользователей уже добавлен");
        } else {
            users.put(user.getEmail(), user);
        }
    }

    @PutMapping
    public void update(@RequestBody User user) throws InvalidEmailException {
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new InvalidEmailException("Некорректный email");
        } else {
            users.put(user.getEmail(), user);
        }
    }
}
