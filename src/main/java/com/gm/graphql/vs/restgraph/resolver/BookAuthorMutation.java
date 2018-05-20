package com.gm.graphql.vs.restgraph.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.gm.graphql.vs.restgraph.domain.Author;
import com.gm.graphql.vs.restgraph.domain.Book;
import com.gm.graphql.vs.restgraph.repository.AuthorRepository;
import com.gm.graphql.vs.restgraph.repository.BookRepository;
import com.gm.graphql.vs.restgraph.exception.UnableToFindBookException;
import org.springframework.stereotype.Component;

@Component
public class BookAuthorMutation implements GraphQLMutationResolver {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookAuthorMutation(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorRepository.save(author);
        return author;
    }

    public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
        Book book = new Book();
        book.setAuthor(new Author(authorId));
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount != null ? pageCount : 0);
        bookRepository.save(book);
        return book;
    }

    public boolean deleteBook(Long id) {
        bookRepository.delete(id);
        return true;
    }

    public Book updateBookPageCount(Integer pageCount, Long id) {
        Book book = bookRepository.findOne(id);
        if(book == null) {
            throw new UnableToFindBookException("The book to be updated was found", id);
        }
        book.setPageCount(pageCount);
        bookRepository.save(book);
        return book;
    }
}