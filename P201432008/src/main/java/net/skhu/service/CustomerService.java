package net.skhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.skhu.domain.Customer;
import net.skhu.model.Option;
import net.skhu.model.Pagination;
import net.skhu.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired CustomerRepository customerRepository;
	
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}
	
	public List<Customer> findAll(Pagination pagination) {
		return customerRepository.findAll(pagination);
	}
	
	public Customer findOne(int id) {
		return customerRepository.findById(id).get();
	}
	
	public Option[] getOrderByOptions() {
        return customerRepository.orderBy;
    }

    public Option[] getSearchByOptions() {
        return customerRepository.searchBy;
    }
}
