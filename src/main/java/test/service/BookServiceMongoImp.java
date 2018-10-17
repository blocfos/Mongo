package test.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import test.model.Book;
import test.repository.*;

@Component
public class BookServiceMongoImp implements BookService{

	@Autowired 
	private BookRepository bookRepository; 
	@Override
	public List<Book> getBookByTitle(String title) {
		// TODO Auto-generated method stub
		return bookRepository.findByTitle(title);
	}
	@Override
	public void generateBooks() {
		// TODO Auto-generated method stub
		List<Book> listBook = new ArrayList<>();
		for(int i = 0; i < 20 ; i ++) {
			Book newBook = new Book("Title" + i, (double) (200 + i));
			listBook.add(newBook);
		}
		bookRepository.saveAll(listBook);
		System.out.println("***OK save book*********");
	}
	@Override
	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		List<Book> listBook = new ArrayList<>();
		Iterable<Book> iBook = bookRepository.findAll();
		Iterator<Book> i = iBook.iterator();
		while(i.hasNext()) {
			Book book = (Book) i.next();
			System.out.println("----" + book.getTitle() +"---");
			listBook.add(book);
			
		}
		return listBook;
		
	}
	//@PostConstruct
	@Override
	public void generateBooksNoPersis() {
		for(int i = 0; i < 20 ; i ++) {
			Book newBook = new Book("Title" + i, (double) (200 + i));
			System.out.println("Book " + i + " " + newBook.getTitle());
		}
	}
	@Override
	public void deleteAllBook() {
		// TODO Auto-generated method stub
		bookRepository.deleteAll();
		
	}

}
