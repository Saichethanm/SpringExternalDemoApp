package com.saichethan.SpringBootProject.service;

import com.saichethan.SpringBootProject.entity.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public User findById(int theId);

    public User save(User theUser);

    public void deleteById(int theId);
}
