package com.saichethan.SpringBootProject.dao;

import com.saichethan.SpringBootProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
