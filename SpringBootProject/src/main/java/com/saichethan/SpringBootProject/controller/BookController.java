package com.saichethan.SpringBootProject.controller;

import com.saichethan.SpringBootProject.entity.Book;
import com.saichethan.SpringBootProject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/list")
    public String showBooks(Model model)
    {
        model.addAttribute("books", bookService.findAll());
        return "books/books";
    }

    @GetMapping("/showFormForAdd")
    public String showBookForm(Model model)
    {
        Book book = new Book();

        model.addAttribute("book", book);

        return "books/book-form";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book book)
    {
        bookService.save(book);

        return "redirect:/books/list";
    }

    @GetMapping("/showFormForUpdate")
    public String bookUpdate(@RequestParam("bookId") int id, Model model)
    {
        Book book = bookService.findById(id);


        model.addAttribute("book", book);

        return "books/book-form";
    }


    @GetMapping("/read")
    public void showBook(HttpServletResponse response, @ModelAttribute("bookId") int id) throws IOException {
//        response.setContentType("application/pdf");
//        Book book = bookService.findById(id);
//        InputStream inputStream = new FileInputStream(new File("/home/saichm/Saichethan/pdfs_for_project/" + book.getName() + ".pdf"));
//        int nRead;
//        while ((nRead = inputStream.read()) != -1) {
//            response.getWriter().write(nRead);
//        }
        bookService.showBook(response, id);
    }

    @GetMapping("/delete")
    public String deleteBook(@ModelAttribute("bookId") int id)
    {
        bookService.deleteById(id);

        return "redirect:/books/list";
    }
}
