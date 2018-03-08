package com.bookstore.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
