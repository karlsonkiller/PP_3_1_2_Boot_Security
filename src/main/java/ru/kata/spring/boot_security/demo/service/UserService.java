package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User foundUser(Long id);
    void save(User user);
    void updateUser(Long id, User user);
    void deleteUser(Long id);
}
