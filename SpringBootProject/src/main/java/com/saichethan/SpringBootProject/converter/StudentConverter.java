package com.saichethan.SpringBootProject.converter;

import com.saichethan.SpringBootProject.dto.StudentDTO;
import com.saichethan.SpringBootProject.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentConverter {



    public StudentDTO entityToDto(Student student) {

//		StudentDTO dto = new StudentDTO();
//		dto.setId(student.getId());
//		dto.setName(student.getName());
//		dto.setUsername(student.getUsername());
//		dto.setPassword(student.getPassword());
//
//		return dto;

        ModelMapper mapper =new ModelMapper();
        StudentDTO map = mapper.map(student, StudentDTO.class);
        return map;

    }
    public List<StudentDTO> entityToDto(List<Student> student) {

        return	student.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

    }


    public Student dtoToEntity(StudentDTO dto)
    {
//		Student st = new Student();
//		st.setId(dto.getId());
//		st.setName(dto.getName());
//		st.setPassword(dto.getPassword());
//		st.setUsername(dto.getUsername());
//
//		return st;

        ModelMapper mapper = new ModelMapper();
        Student map = mapper.map(dto, Student.class);
        return map;
    }

    public List<Student> dtoToEntity(List<StudentDTO> dto)
    {

        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }

}
