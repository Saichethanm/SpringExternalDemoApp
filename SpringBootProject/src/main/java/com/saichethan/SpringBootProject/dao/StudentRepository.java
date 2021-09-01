package com.saichethan.SpringBootProject.dao;

import com.saichethan.SpringBootProject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    // that's it ... no need to write any code LOL!

    // add a method to sort by last name

    public List<Student> findAllByOrderByLastNameAsc();

}
