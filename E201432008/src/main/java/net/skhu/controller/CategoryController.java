package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.Category;
import net.skhu.mapper.CategoryMapper;

@Controller
@RequestMapping("/home")
public class CategoryController {
	
	@Autowired CategoryMapper categoryMapper;
    @RequestMapping("test1")
    public String list(Model model) {
        List<Category> categories = categoryMapper.findAll();
        model.addAttribute("categories", categories);
        return "home/test1";
    }
    
    @RequestMapping("test2")
    public String add(Model model) {
        model.addAttribute("number", 123);
        return "home/test2";
    }	
}