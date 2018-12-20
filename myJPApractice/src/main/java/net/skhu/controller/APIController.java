package net.skhu.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.domain.Book;
import net.skhu.domain.Category;
import net.skhu.domain.Publisher;
import net.skhu.service.BookService;
import net.skhu.service.CategoryService;
import net.skhu.service.PublisherService;

@RestController
@RequestMapping("api")
public class APIController {
	@Autowired BookService bookService;
	@Autowired CategoryService categoryService;
	@Autowired PublisherService publisherService;
	@Autowired JpaContext jpaContext;
	
	@RequestMapping("books")
    public List<Book> employees() {
        return bookService.findAll();
    }
	
	@RequestMapping("book/{id}")
    public Book employee(@PathVariable("id") int id) {
        return bookService.findOne(id);
    }
	
	@RequestMapping("categories")
    public List<Category> categories() {
        return categoryService.findAll();
    }
	
	@RequestMapping("category/{id}/books")
    public List<Book> categoryBooks(@PathVariable("id") int id) {
		Category category = categoryService.findOne(id);
        return category.getBooks();
    }
	
	@RequestMapping("publishers")
    public List<Publisher> publishers() {
        return publisherService.findAll();
    }
	
	@RequestMapping("publisher/{id}/books")
    public List<Book> publisherBooks(@PathVariable("id") int id) {
		Publisher publisher = publisherService.findOne(id);
        return publisher.getBooks();
    }
	
	@RequestMapping("jpql")
	public Object jpql(@RequestParam("s") String s) {
		EntityManager manager = jpaContext.getEntityManagerByManagedType(Book.class);
        Query query = manager.createQuery(s);
        Object r = query.getResultList();
        return r;
	}
}
