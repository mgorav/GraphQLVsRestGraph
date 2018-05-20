package com.gm.graphql.vs.restgraph.repository;

import com.gm.graphql.vs.restgraph.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository  extends CrudRepository<Author, Long> {

}