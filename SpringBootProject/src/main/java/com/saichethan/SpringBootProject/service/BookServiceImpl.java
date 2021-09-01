package com.saichethan.SpringBootProject.service;

import com.saichethan.SpringBootProject.dao.BookRepository;
import com.saichethan.SpringBootProject.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository theBookRepository) {
        bookRepository = theBookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAllByOrderByNameAsc();
    }

    @Override
    public Book findById(int theId) {

//        System.out.println("-------------------------------------------------HELLLOOOOOOOOOOOO----------------------------------");
        Optional<Book> result = bookRepository.findById(theId);
//        System.out.println("-------------------------------------------------HELLLOOOOOOOOOOOO----------------------------------");

        Book temp = result.get();

        System.out.println(temp);
        Book theBook = null;

        if (result.isPresent()) {
            theBook = result.get();
        }
        else {
            // we didn't find the Book
            throw new RuntimeException("Did not find Book id - " + theId);
        }

        return theBook;
    }

    @Override
    public void save(Book theBook) {
        bookRepository.save(theBook);
    }

    @Override
    public void deleteById(int theId) {
        bookRepository.deleteById(theId);
    }

    @Override
    public void showBook(HttpServletResponse response, int id) throws IOException {
        response.setContentType("application/pdf");
        Book book = findById(id);
        InputStream inputStream = new FileInputStream(new File("/home/saichm/Saichethan/pdfs_for_project/" + book.getName() + ".pdf"));
        int nRead;
        while ((nRead = inputStream.read()) != -1) {
            response.getWriter().write(nRead);
        }
    }

}
