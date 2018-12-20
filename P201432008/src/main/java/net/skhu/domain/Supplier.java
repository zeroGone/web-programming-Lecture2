package net.skhu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "suppliers")
@Entity
@Data
public class Supplier {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String company;
	
	@Column(name = "last_name")
	String lastName;
	
	@Column(name = "first_name")
	String firstName;
}
