package test.main;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import test.model.Book;
import test.model.BookSingleton;
import test.repository.BookRepository;
import test.service.BookService;
import test.service.BookServiceImp;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"test.service", "test.repository"})
@EntityScan("test.model")
//@EnableJpaRepositories(repositoryFactoryBeanClass=BookRepository.class)
@EnableMongoRepositories("test.repository")
public class Application {

	@Autowired
	//@Qualifier("bookServiceImp")
	private BookService bookService;
	
	public void test() {
		System.out.println("*************************************");
		bookService.generateBooksNoPersis();
		System.out.println("*************************************");
	}
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
        	//bookService.deleteAllBook();
        	//bookService.generateBooksNoPersis();
        	//bookService.generateBooks();
        	//bookService.getAllBook();
        	//this.testJava();
        	//this.testSingleton();
        	System.out.println("TEST------------------------");
        	String t;
        	this.testJavaReader();
        	
        };
    }
    private void testJava() {
    	int x = 0;
    	int y = x;
    	x = 10;
    	System.out.println("x" + x);
    	System.out.println("y" + y);
    	System.out.println("-------------");
    	Integer ix = new Integer(10);
    	Integer iy = ix;
    	ix = 15;
    	System.out.println("ix " + ix);
    	System.out.println("iy " + iy);
    	System.out.println("-------------");
    	Book b1 = new Book("Teuton", (double)20);
    	Book b2 = b1;
    	b1.setTitle("yoyo");
    	//b1 = new Book("Toto", (double)10);
    	System.out.println(b1.toString());
    	System.out.println(b2.toString());	
    	System.out.println("-------------");
    	testReference(b1);
    	System.out.println(b1.toString());
    }
    private void testReference(Book b) {
    	b.setTitle("PPPP");
    	b = new Book("DDDD", (double) 30);
    }
    private void testSingleton() {
    	//------------
    	BookSingleton bs3 = BookSingleton.getInstance();
    	bs3.setTitle("kkkkkk");
    	BookSingleton bs4 = BookSingleton.getInstance();
    	bs4.setTitle("lllll");
    	System.out.println(bs3.getTitle());
    	System.out.println(bs4.getTitle());
    	Map<String, Character> mapElement = new HashMap();
    	mapElement.put("AAAA",'A');
    }
    
    private void testJavaReader() throws IOException{
    	String s = "Hello World";
        Reader reader = new StringReader(s);
        try {
           // read the first five chars
           for (int i = 0; i < 5; i++) {
              char c = (char) reader.read();
              System.out.print("" + c);
           }

           // change line
           System.out.println();

           // close the stream
           reader.close();

        } catch (IOException ex) {
        	ex.printStackTrace();
        	throw ex;
        }finally {
        	System.out.println("call finally");
        }
    }

}