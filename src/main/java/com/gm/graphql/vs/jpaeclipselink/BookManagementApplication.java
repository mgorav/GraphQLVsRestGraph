package com.gm.graphql.vs.jpaeclipselink;

import com.gm.graphql.vs.jpaeclipselink.domain.Author;
import com.gm.graphql.vs.jpaeclipselink.domain.Book;
import com.gm.graphql.vs.jpaeclipselink.repository.AuthorRepository;
import com.gm.graphql.vs.jpaeclipselink.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import static java.lang.String.format;
import static java.lang.String.valueOf;
import static java.util.stream.IntStream.range;

@SpringBootApplication
@EnableJpaRepositories
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@EntityScan
public class BookManagementApplication {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BookManagementApplication.class, args);
    }

    @Bean
    @Transactional
    public ApplicationRunner applicationRunner() {
        return applicationArguments -> {
            range(0, 10).forEach(cnt -> {
                Author author = new Author(format("name%d", cnt), format("lastname%d", cnt));
                authorRepository.save(author);

                // String title, String isbn, int pageCount, Author author
                Book book = new Book(format("title%d", cnt), valueOf(cnt), cnt++ * 100, author);
                bookRepository.save(book);
            });

        };


    }


}
