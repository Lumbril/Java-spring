package org.example.service;

import org.example.entity.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    void delete(long id);
    User getByLogin(String name);
    User editUser(User user);
    List<User> getAll();
}
