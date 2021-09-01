package com.saichethan.SpringBootProject.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name="author_name")
    private String authorName;

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name="book_student",
            joinColumns=@JoinColumn(name = "book_id"),
            inverseJoinColumns=@JoinColumn(name = "student_id")
    )
    private List<Student> students;

    public Book() {
    }

    public Book(String name, String authorName, String description) {
        this.name = name;
        this.authorName = authorName;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // add a convenience method

    public void addStudent(Student student)
    {
        if(students == null)
            students = new ArrayList<>();
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authorName='" + authorName + '\'' +
                ", description='" + description + '\'' +
                ", students=" + students +
                '}';
    }
}
