package com.innopolis.carrentapp.service;

import com.innopolis.carrentapp.model.User;
import com.innopolis.carrentapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class UserDatabaseService implements UserService{

    private final UserRepository userRepository;

    @Override
    public User getById(UUID id) {

        return userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, format("User with id %d not found",id)));
    }

    @Override
    public List<User> getAll() {
        Iterable<User> usersIterable = userRepository.findAll();
        List<User> usersList = new ArrayList<>();
        usersIterable.forEach(usersList::add);
        return usersList;
    }

    @Override
    public User createUser(User user) {
        user.setId(UUID.randomUUID());
        return userRepository.save(user);
    }

    @Override
    public User updateUser(UUID id, User user) {

        User userFromDatabase = getById(id);
        User userToUpdate = userFromDatabase.toBuilder()
                .email(user.getEmail())
                .password(user.getPassword())
                .phone(user.getPhone())
                .driverLicense(user.getDriverLicense())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();

        return userRepository.save(userToUpdate);
    }

    @Override
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> search(String term) {

        return userRepository.findAllByEmailIsLike(term);
    }
}
