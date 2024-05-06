package ru.kata.spring.boot_security.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repo.UserRepos;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepos userRepos;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepos userRepo, PasswordEncoder passwordEncoder) {
        this.userRepos = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAllUser() {
        return userRepos.findAll();
    }

    @Override
    public User foundUser(Long id) {
        return userRepos.getById(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        userRepos.save(user);
    }

    @Override
    @Transactional
    public void updateUser(Long id, User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setId(id);
        userRepos.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepos.deleteById(id);
    }

    @Override
    public Object findByUsername(String name) {
        return userRepos.findByUsername(name);
    }
}