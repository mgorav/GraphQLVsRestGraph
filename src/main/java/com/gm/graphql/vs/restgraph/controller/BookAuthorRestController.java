package com.gm.graphql.vs.restgraph.controller;

import com.gm.graphql.vs.restgraph.domain.Book;
import com.gm.graphql.vs.restgraph.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "bookmgmt")
public class BookAuthorRestController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping(value = "/books")
    public List<Book> findAllBooks() {
        List<Book> books = new ArrayList<>();

        bookRepository.findAll().forEach(books::add);
        return books;
    }
}
