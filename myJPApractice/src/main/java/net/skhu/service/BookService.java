package net.skhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import net.skhu.domain.Book;
import net.skhu.domain.Category;
import net.skhu.domain.Publisher;
import net.skhu.model.BookModel;
import net.skhu.model.Option;
import net.skhu.model.Pagination;
import net.skhu.repository.BookRepository;
import net.skhu.repository.CategoryRepository;

@Service
public class BookService {
	@Autowired BookRepository bookRepository;
	@Autowired CategoryRepository categoryRepository;
	
	public Book findOne(int id) {
		return bookRepository.findById(id).get();
	}
	
	public List<Book> findAll(Pagination pagination) {
		return bookRepository.findAll(pagination);
	}

	public List<Book> findAll(){
		return bookRepository.findAll();
	}
	
	public Option[] getOrderByOptions() {
        return bookRepository.orderBy;
    }

    public Option[] getSearchByOptions() {
        return bookRepository.searchBy;
    }
    
    @Query("SELECT b from Book b")
	List<Book> findBooks(){
    	return bookRepository.findAll();
    };
    
    @Query("SELECT b FROM Book b WHERE b.category.id = ?1")
    List<Book> findBooksByCategoryId(int categoryId){
    	Category category = categoryRepository.findById(categoryId).get();
    	return category.getBooks();
    }

//    @Query("SELECT b FROM Book b WHERE b.id = ?1 OR b.title = ?2")
//    List<Book> findBooksByIdOrTitle(String id, String title){
//    	return bookRepository.findBooksByIdOrTitle(id, title);
//    }
    
    @Query("SELECT b FROM Book b WHERE b.id = :id OR b.title = :title")
    List<Book> findStudentsByStudentNoOrName2(@Param("id") String id, @Param("title") String title){
    	return bookRepository.findBooksByIdOrTitle(id, title);
    }
    
    public void update(BookModel b) {
    	bookRepository.update(b.getId(),b.getTitle(),b.getAuthor(),b.getPrice(),b.getCategoryId(),b.getPublisherId(),b.isAvailable());
    }

    public int insertArticle(BookModel b) {
        Book book = new Book();
        book.setTitle(b.getTitle());
        book.setAuthor(b.getAuthor());
        book.setPrice(b.getPrice());
        book.setAvailable(b.isAvailable());
        book.setCategory(new Category());
        book.getCategory().setId(b.getCategoryId());
        book.setPublisher(new Publisher());
        book.getPublisher().setId(b.getPublisherId());
        bookRepository.save(book);
        
        return book.getId();
    }
}
