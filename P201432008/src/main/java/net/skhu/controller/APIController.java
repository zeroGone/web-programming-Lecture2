package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.domain.Customer;
import net.skhu.domain.Product;
import net.skhu.service.CustomerService;
import net.skhu.service.OrderService;

@RestController
@RequestMapping("api")
public class APIController {
	@Autowired OrderService orderService;
	@Autowired CustomerService customersService;
	
	@RequestMapping("order/{id}/products")
	public List<Product> orderProducts(@PathVariable("id") int id){
		return orderService.findByIdProducts(id);
	}
	
	
	@RequestMapping("customers")
	public List<Customer> customers(){
		return customersService.findAll();
	}
	
}
