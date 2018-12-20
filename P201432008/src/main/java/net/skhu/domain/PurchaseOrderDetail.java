package net.skhu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "purchase_order_details")
@Entity
@Data
public class PurchaseOrderDetail {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	Product product;
	
	Double quantity;

	@Column(name = "unit_cost")
	Double unitCost;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "purchase_order_id")
	PurchaseOrder purchaseOrder;
	
	
	
}
