package net.skhu.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.model.BookModel;
import net.skhu.model.Pagination;
import net.skhu.service.BookService;
import net.skhu.service.CategoryService;
import net.skhu.service.PublisherService;

@Controller
@RequestMapping("book")
public class BookController {

	@Autowired BookService bookService;
	@Autowired CategoryService categoryService;
	@Autowired PublisherService publisherService;

	@RequestMapping("list")
	public String list(Pagination pagination, Model model) {
		model.addAttribute("list", bookService.findAll(pagination));
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("publishers", publisherService.findAll());
		model.addAttribute("orderBy", bookService.getOrderByOptions());
        model.addAttribute("searchBy", bookService.getSearchByOptions());
		return "book/list";
	}
	
    @RequestMapping("view")
    public String view(@RequestParam("id") int id, Pagination pagination, Model model) {
        model.addAttribute("book", bookService.findOne(id));
        return "book/view";
    }
    
    @RequestMapping(value="edit", method=RequestMethod.GET)
    public String edit(@RequestParam("id") int id, Pagination pagination, Model model) {
    	model.addAttribute("bookModel", new BookModel(bookService.findOne(id)));
    	model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("publishers", publisherService.findAll());
        model.addAttribute("pagination", pagination);
    	return "book/edit";
    }
        
    @RequestMapping(value="create", method=RequestMethod.GET)
    public String create(Pagination pagination, Model model) {
    	model.addAttribute("bookModel", new BookModel());
    	model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("publishers", publisherService.findAll());
        model.addAttribute("pagination", pagination);
        return "book/edit";
    }
    
    @Transactional
    @RequestMapping(value="edit", method=RequestMethod.POST)
    public String edit(@Valid BookModel b, BindingResult bindingResult,
            Pagination pagination, Model model) {
        if (bindingResult.hasErrors()) {
        	model.addAttribute("categories", categoryService.findAll());
            model.addAttribute("publishers", publisherService.findAll());
            return "book/edit";
        }
        bookService.update(b);
        return "redirect:view?id=" + b.getId() + "&" + pagination.getQueryString();
    }

    @Transactional
    @RequestMapping(value="create", method=RequestMethod.POST)
    public String create(@Valid BookModel b, BindingResult bindingResult,
            Pagination pagination, Model model) {
        if (bindingResult.hasErrors()) {
        	model.addAttribute("categories", categoryService.findAll());
            model.addAttribute("publishers", publisherService.findAll());
            return "book/edit";
        }
        int id = bookService.insertArticle(b);
        return "redirect:view?id=" +id + "&" + pagination.getQueryString();
    }
}
