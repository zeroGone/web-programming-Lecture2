package net.skhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.skhu.domain.PurchaseOrderDetail;
import net.skhu.repository.PurchaseOrderDetailRepository;

@Service
public class PurchaseOrderDetailService {

	@Autowired PurchaseOrderDetailRepository purchaseOrderDetailRepository;
	
	public List<PurchaseOrderDetail> findAll(){
		return purchaseOrderDetailRepository.findAll();
	}
}
