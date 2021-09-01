package com.saichethan.SpringBootProject.service;

import com.saichethan.SpringBootProject.dto.StudentDTO;
import com.saichethan.SpringBootProject.entity.Student;

import java.util.List;

public interface StudentService {
    
    public List<Student> findAll();

    public Student findById(int theId);

    public void save(Student theStudent);

    public void deleteById(int theId);
    
}
