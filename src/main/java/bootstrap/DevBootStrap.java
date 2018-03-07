package bootstrap;


import com.bookstore.model.Author;
import com.bookstore.model.Book;
import com.bookstore.repositories.AuthorRepository;
import com.bookstore.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;



@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent>{
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	
	public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository) {
	this.authorRepository = authorRepository;
	this.bookRepository = bookRepository;
	}
	

	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		initData();		
	}
	private void initData(){
		
		Author raouf = new Author("raouf","Ghalem");
		Book daBook	= new Book("myBook", "654632", "itsMe");
		raouf.getBooks().add(daBook);
		daBook.getAuthors().add(raouf);
		
		authorRepository.save(raouf);
		bookRepository.save(daBook);
		
		
		
		Author yassine = new Author("yass","Ghalem");
		Book hisBook	= new Book("hisBook", "87613", "itshim");
		yassine.getBooks().add(hisBook);
				
		authorRepository.save(yassine);
	
	}

	
}
