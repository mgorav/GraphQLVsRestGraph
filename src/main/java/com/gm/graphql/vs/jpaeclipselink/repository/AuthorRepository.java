package com.gm.graphql.vs.jpaeclipselink.repository;

import com.gm.graphql.vs.jpaeclipselink.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository  extends CrudRepository<Author, Long> {

}