package com.saichethan.SpringBootProject.controller;

import com.saichethan.SpringBootProject.converter.StudentConverter;
import com.saichethan.SpringBootProject.entity.Student;
import com.saichethan.SpringBootProject.service.BookService;
import com.saichethan.SpringBootProject.service.StudentService;
import com.saichethan.SpringBootProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String showStudent(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students/student";
    }

    @GetMapping("/showFormForAdd")
    public String showstudentForm(Model model) {
        Student student = new Student();

        model.addAttribute("student", student);

        return "students/student-form";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);

        return "redirect:/students/list";
    }

    @GetMapping("/showFormForUpdate")
    public String studentUpdate(@RequestParam("studentId") int id, Model model) {
        Student student = studentService.findById(id);

        model.addAttribute("student", student);

        return "students/student-form";
    }

    @GetMapping("/delete")
    public String deleteStudent(@ModelAttribute("studentId") int id) {

        userService.deleteById(id);

        return "redirect:/students/list";
    }
}















/**
 * package com.saichethan.SpringBootProject.controller;
 *
 * import com.saichethan.SpringBootProject.entity.Student;
 * import com.saichethan.SpringBootProject.service.BookService;
 * import com.saichethan.SpringBootProject.service.StudentService;
 * import com.saichethan.SpringBootProject.service.UserService;
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.stereotype.Controller;
 * import org.springframework.ui.Model;
 * import org.springframework.web.bind.annotation.*;
 *
 * @Controller
 * @RequestMapping("/students")
 * public class StudentController {
 *
 *     @Autowired
 *     private StudentService studentService;
 *
 *     @Autowired
 *     private UserService userService;
 *
 *     @GetMapping("/list")
 *     public String showStudent(Model model) {
 *         model.addAttribute("students", studentService.findAll());
 *         return "students/student";
 *     }
 *
 *     @GetMapping("/showFormForAdd")
 *     public String showstudentForm(Model model) {
 *         Student student = new Student();
 *
 *         model.addAttribute("student", student);
 *
 *         return "students/student-form";
 *     }
 *
 *     @PostMapping("/save")
 *     public String saveStudent(@ModelAttribute("student") Student student) {
 *         studentService.save(student);
 *
 *         return "redirect:/students/list";
 *     }
 *
 *     @GetMapping("/showFormForUpdate")
 *     public String studentUpdate(@RequestParam("studentId") int id, Model model) {
 *         Student student = studentService.findById(id);
 *
 *         model.addAttribute("student", student);
 *
 *         return "students/student-form";
 *     }
 *
 *     @GetMapping("/delete")
 *     public String deleteStudent(@ModelAttribute("studentId") int id) {
 *
 *         userService.deleteById(id);
 *
 *         return "redirect:/students/list";
 *     }
 * }
 */
