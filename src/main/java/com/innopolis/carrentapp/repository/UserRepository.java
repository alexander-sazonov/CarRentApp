package com.innopolis.carrentapp.repository;

import com.innopolis.carrentapp.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID>{

    List<User> findAllByEmailIsLike(String term);
}
