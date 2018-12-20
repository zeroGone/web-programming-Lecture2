package net.skhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.skhu.domain.Category;
import net.skhu.repository.CategoryRepository;

@Service
public class CategoryService {
@Autowired CategoryRepository categoryRepository;
	
	public Category findOne(int id) {
		return categoryRepository.findById(id).get();
	}
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
}
