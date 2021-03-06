package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.Publisher;

@Mapper
public interface PublisherMapper {
    Publisher findOne(int id);
    Publisher findOneByTitle(String title);
    List<Publisher> findAll();
}


