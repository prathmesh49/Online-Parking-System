package com.example.serviceInterfaces;

import com.example.model.User;

public interface UserService {
    User getUserById(int userId);
    User getUserByUsername(String username);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int userId);
}
