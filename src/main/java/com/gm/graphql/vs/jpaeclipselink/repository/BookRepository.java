package com.gm.graphql.vs.jpaeclipselink.repository;

import com.gm.graphql.vs.jpaeclipselink.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

}