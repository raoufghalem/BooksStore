package com.bookstore.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.model.Author;

public interface AuthorRepository extends CrudRepository<Author,Long>{

}
