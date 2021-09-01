package com.saichethan.SpringBootProject.service;

import com.saichethan.SpringBootProject.dao.UserRepository;
import com.saichethan.SpringBootProject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository theUserRepository) {
        userRepository = theUserRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int theId) {

        Optional<User> result = userRepository.findById(theId);

        User temp = result.get();

        System.out.println(temp);
        User theUser = null;

        if (result.isPresent()) {
            theUser = result.get();
        }
        else {
            // we didn't find the Book
            throw new RuntimeException("Did not find user id - " + theId);
        }

        return theUser;
    }

    @Override
    public User save(User theUser) {
        System.out.println("I came till here and then the error occured");
        System.out.println(theUser);
        userRepository.save(theUser);
        return theUser;
    }

    @Override
    public void deleteById(int theId) {


        userRepository.deleteById(theId);
    }
}
