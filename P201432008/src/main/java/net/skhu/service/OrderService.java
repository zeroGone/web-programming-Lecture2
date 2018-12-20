package net.skhu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.skhu.domain.Order;
import net.skhu.domain.OrderDetail;
import net.skhu.domain.Product;
import net.skhu.repository.OrderDetailRepository;
import net.skhu.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired OrderRepository orderRepository;
	@Autowired OrderDetailRepository orderDetailRepository;
	
	public List<Order> findAll(){
		return orderRepository.findAll();
	}
	
	public List<Product> findByIdProducts(int id) {
		List<Product> products = new ArrayList<>();
		List<OrderDetail> orderDetails = orderDetailRepository.findByOrderId(id);
		for(OrderDetail orderDetail:orderDetails) products.add(orderDetail.getProduct());
		return products;
	}
}
