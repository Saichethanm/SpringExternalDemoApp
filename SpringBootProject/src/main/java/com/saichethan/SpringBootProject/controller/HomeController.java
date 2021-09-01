package com.saichethan.SpringBootProject.controller;

import com.saichethan.SpringBootProject.entity.*;
import com.saichethan.SpringBootProject.helper.MakeAdmin;
import com.saichethan.SpringBootProject.helper.Registration;
import com.saichethan.SpringBootProject.helper.UpdatePassword;
import com.saichethan.SpringBootProject.service.StudentService;
import com.saichethan.SpringBootProject.service.UserService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@Component
public class HomeController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @GetMapping("/home")
    public String showHome()
    {
        return "home";
    }

    @GetMapping("/login")
    public String showLogin()
    {
        return "login";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied()
    {
        return "access-denied";
    }

    @GetMapping("/welcome")
    public String showWelcome(Model model)
    {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        int id = Integer.parseInt(name);
        Student student = studentService.findById(id);
        System.out.println(student);
        model.addAttribute(student);
        return "welcomePage";
    }

    @GetMapping("/logout")
    public String afterLogout()
    {
        System.out.println("--------LOGOUTTTT-----------");
        return "redirect:/home";
    }

    @GetMapping("/register")
    public String showRegistrationForm()
    {
        return "register";
    }

    @GetMapping("/error")
    public String showError(){
        return "error";
    }

    @PostMapping("/addNewStudent")
    public String addNewStudent(@ModelAttribute("register") Registration registration, Model model) {

        System.out.println(registration);

        Student student = new Student(registration.getFirstName(), registration.getLastName(), registration.getEmail());

        Authorities authority1 = new Authorities("ROLE_STUDENT");
//        Authorities authority2 = new Authorities("ROLE_ADMIN");

        List<Authorities> authoritiesList = new ArrayList<>();
        authoritiesList.add(authority1);
//        authoritiesList.add(authority2);

        User user = new User(student, registration.getPassword() , authoritiesList);

//        System.out.println("-----");
        student.setUser(user);
//        System.out.println("----");
//
//        System.out.println(user);

//        System.out.println(authoritiesList);

//        System.out.println(student);

        studentService.save(student);
        userService.save(user);

        model.addAttribute(student);

//        System.out.println("REQUIRED IMPORTANT THING ------------>>>>> "  + student.getUser().getId());

        return "sample";
    }

    @GetMapping("/makeadminform")
    public String showForm()
    {
        return "/admin/make-admin-form";
    }


    @PostMapping("/makeadmin")
    public String makeAdmin(@ModelAttribute("makeadmin") MakeAdmin makeAdmin, Model model)
    {
        User user = userService.findById(makeAdmin.getId());
        user.getAuthorities();
        Authorities authority = new Authorities("ROLE_ADMIN");
        System.out.println(authority);
        user.add(authority);
        System.out.println(user);
        userService.save(user);
        return "/admin/adminSuccess";
    }


    @GetMapping("/updatepasswordform")
    public String showFormForUpdatePassword()
    {
        return "/updatepassword/updatepasswordform";
    }


    @PostMapping("/updatepassword")
    public String makeAdmin(@ModelAttribute("updatepassword") UpdatePassword updatePassword, Model model)
    {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        int id = Integer.parseInt(name);

        User user = userService.findById(id);

        System.out.println(updatePassword);

        if(!BCrypt.checkpw(updatePassword.getOldPassword(), user.getPassword())) {
                return "redirect:/updatepasswordform?error=true";
        }
        user.setPassword(passwordEncoder().encode(updatePassword.getNewPassword()));

        userService.save(user);

        return "/updatepassword/updatepasswordsuccess";
    }

}
