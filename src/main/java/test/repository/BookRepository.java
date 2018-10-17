package test.repository;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import test.model.Book;

public interface BookRepository extends MongoRepository<Book, Long> {
	public List<Book> findByTitle(String title);
	
}