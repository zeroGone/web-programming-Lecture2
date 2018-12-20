package net.skhu.model;


import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;
import net.skhu.domain.Book;

@Data
public class BookModel {
	public BookModel() {
		
	}
	
	public BookModel(Book book) {
		this.id=book.getId();
		this.title=book.getTitle();
		this.author=book.getAuthor();
		this.price=book.getPrice();
		this.setAvailable(book.isAvailable());
		this.categoryId=book.getCategory().getId();
		this.publisherId=book.getPublisher().getId();
	}
	
	int id;
	
	@NotEmpty(message="제목을 입력하세요")
    String title;

    String author;
    
    @Max(1000000)
    int price;
    
    boolean available;
    
    int categoryId;
    int publisherId;
}
