package com.bookstore.bootstrap;


import com.bookstore.model.Author;
import com.bookstore.model.Book;
import com.bookstore.model.Publisher;
import com.bookstore.repositories.AuthorRepository;
import com.bookstore.repositories.BookRepository;
import com.bookstore.repositories.PublisherRepository;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;



@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent>{
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
	this.authorRepository = authorRepository;
	this.bookRepository = bookRepository;
	this.publisherRepository = publisherRepository;
	}
	

	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		initData();		
	}
	private void initData(){
		
		Publisher pub = new Publisher("Ipublish","1200 jean talon");
		publisherRepository.save(pub);
		
		Author raouf = new Author("raouf","Ghalem");
		Book daBook	= new Book("myBook", "46543232" , pub);		
		raouf.getBooks().add(daBook);
		daBook.getAuthors().add(raouf);
		
		authorRepository.save(raouf);
		bookRepository.save(daBook);
				
		
		
		Author yassine = new Author("yass","Ghalem");
		Book hisBook	= new Book("hisBook", "87613",pub);
		yassine.getBooks().add(hisBook);
		hisBook.getAuthors().add(yassine);
				
		authorRepository.save(yassine);
		bookRepository.save(hisBook);
	
	}

	
}
