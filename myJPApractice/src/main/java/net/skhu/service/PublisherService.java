package net.skhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.skhu.domain.Publisher;
import net.skhu.repository.PublisherRepository;

@Service
public class PublisherService {
	@Autowired PublisherRepository publisherRepository;
	
	public Publisher findOne(int id) {
		return publisherRepository.findById(id).get();
	}
	
	public List<Publisher> findAll(){
		return publisherRepository.findAll();
	}
	
}
