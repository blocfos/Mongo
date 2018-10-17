package test.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Author")
public class Author {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String _id;
    private String name;
    private String country;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Author(String name, String country) {
		super();
		this.name = name;
		this.country = country;
	}
	public Author() {
		
	}
	
}
