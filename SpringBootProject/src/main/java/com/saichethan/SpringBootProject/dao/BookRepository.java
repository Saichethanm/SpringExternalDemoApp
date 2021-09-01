package com.saichethan.SpringBootProject.dao;

import com.saichethan.SpringBootProject.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

        // that's it ... no need to write any code LOL!

        // add a method to sort by last name

        public List<Book> findAllByOrderByNameAsc();

}

