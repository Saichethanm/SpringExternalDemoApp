package com.saichethan.SpringBootProject.service;

import com.saichethan.SpringBootProject.entity.Book;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface BookService {

    public List<Book> findAll();

    public void showBook(HttpServletResponse response, int id) throws IOException;

    public Book findById(int theId);

    public void save(Book theBook);

    public void deleteById(int theId);
}
