package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.mapper.BookMapper;
import net.skhu.mapper.CategoryMapper;
import net.skhu.mapper.PublisherMapper;

@Controller
@RequestMapping("/home")
public class PublisherController {
	
	@Autowired BookMapper bookMapper; 
	@Autowired CategoryMapper categoryMapper;
	@Autowired PublisherMapper publisherMapper;
	
}
