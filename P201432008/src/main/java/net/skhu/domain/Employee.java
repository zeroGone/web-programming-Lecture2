package net.skhu.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Table(name="employees")
@Entity
@ToString(exclude= "orders")
@EqualsAndHashCode(exclude= "orders")
@Data
public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String company;
	
	@Column(name = "last_name")
	String lastName;
	
	@Column(name = "first_name")
	String firstName;
	
	@Column(name = "email_address")
	String email;
	
	@Column(name = "job_title")
	String job;
	
	String city;
	String notes;
	
	@JsonIgnore
    @OneToMany(mappedBy="employee", fetch = FetchType.LAZY)
	List<Order> orders;
	
}
