package com.innopolis.carrentapp.service;

import com.innopolis.carrentapp.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User getById(UUID id);
    List<User> getAll();
    User createUser(User user);
    User updateUser(UUID id, User user);
    void delete(UUID id);
    List<User> search(String term);
}
