package com.saichethan.SpringBootProject.service;

import com.saichethan.SpringBootProject.converter.StudentConverter;
import com.saichethan.SpringBootProject.dao.StudentRepository;
import com.saichethan.SpringBootProject.dto.StudentDTO;
import com.saichethan.SpringBootProject.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository StudentRepository;


    @Autowired
    public StudentServiceImpl(StudentRepository theStudentRepository) {
        StudentRepository = theStudentRepository;
    }

    @Override
    public List<Student> findAll() {
        return StudentRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Student findById(int theId) {
        Optional<Student> result = StudentRepository.findById(theId);

        Student theStudent = null;

        if (result.isPresent()) {
            theStudent = result.get();
        }
        else {
            // we didn't find the Student
            throw new RuntimeException("Did not find Student id - " + theId);
        }

        return theStudent;
    }

    @Override
    public void save(Student theStudent) {

        StudentRepository.save(theStudent);
    }

    @Override
    public void deleteById(int theId) {
        StudentRepository.deleteById(theId);
    }

}


/**
 * package com.saichethan.SpringBootProject.service;
 *
 * import com.saichethan.SpringBootProject.dao.StudentRepository;
 * import com.saichethan.SpringBootProject.entity.Student;
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.stereotype.Service;
 *
 * import java.util.List;
 * import java.util.Optional;
 *
 * @Service
 * public class StudentServiceImpl implements StudentService{
 *
 *     private StudentRepository StudentRepository;
 *
 *     @Autowired
 *     public StudentServiceImpl(StudentRepository theStudentRepository) {
 *         StudentRepository = theStudentRepository;
 *     }
 *
 *     @Override
 *     public List<Student> findAll() {
 *         return StudentRepository.findAllByOrderByLastNameAsc();
 *     }
 *
 *     @Override
 *     public Student findById(int theId) {
 *         Optional<Student> result = StudentRepository.findById(theId);
 *
 *         Student theStudent = null;
 *
 *         if (result.isPresent()) {
 *             theStudent = result.get();
 *         }
 *         else {
 *             // we didn't find the Student
 *             throw new RuntimeException("Did not find Student id - " + theId);
 *         }
 *
 *         return theStudent;
 *     }
 *
 *     @Override
 *     public void save(Student theStudent) {
 *         StudentRepository.save(theStudent);
 *     }
 *
 *     @Override
 *     public void deleteById(int theId) {
 *         StudentRepository.deleteById(theId);
 *     }
 *
 * }
 */