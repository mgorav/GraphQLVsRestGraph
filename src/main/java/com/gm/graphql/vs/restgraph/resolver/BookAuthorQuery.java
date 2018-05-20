package com.gm.graphql.vs.restgraph.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.gm.graphql.vs.restgraph.domain.Author;
import com.gm.graphql.vs.restgraph.domain.Book;
import com.gm.graphql.vs.restgraph.repository.AuthorRepository;
import com.gm.graphql.vs.restgraph.repository.BookRepository;
import org.springframework.stereotype.Component;

@Component
public class BookAuthorQuery implements GraphQLQueryResolver {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    public BookAuthorQuery(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public Long countBooks() {
        return bookRepository.count();
    }

    public Long countAuthors() {
        return authorRepository.count();
    }
}
