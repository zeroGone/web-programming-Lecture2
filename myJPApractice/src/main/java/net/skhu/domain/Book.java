package net.skhu.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(exclude= {"category", "publisher"})
@EqualsAndHashCode(exclude= {"category", "publisher"})
@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String title;
	String author;
	int price;
	boolean available;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryId")
	Category category;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "publisherId")
	Publisher publisher;
}
