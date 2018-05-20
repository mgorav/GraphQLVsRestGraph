package com.gm.graphql.vs.restgraph.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.gm.graphql.vs.restgraph.domain.Author;
import com.gm.graphql.vs.restgraph.domain.Book;
import com.gm.graphql.vs.restgraph.repository.AuthorRepository;
import org.springframework.stereotype.Component;

@Component
public class BookResolver implements GraphQLResolver<Book> {

    private AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Book book) {
        return authorRepository.findOne(book.getAuthor().getId());
    }
}
