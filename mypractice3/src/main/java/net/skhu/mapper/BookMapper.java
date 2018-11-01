package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import net.skhu.dto.Book;

@Mapper
public interface BookMapper {
	List<Book> findAllWithPublisherAndCategory();
	List<Book> findAllOrderBy(@Param("order") String order);
	List<Book> findByTitleAndOrderBy(@Param("book") Book book, @Param("order") String order);
	Book findOne(int id);
	
    void insert(Book book);
    void update(Book book);
    void delete(int id);
}
