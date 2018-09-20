package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import net.skhu.dto.Department;
import net.skhu.dto.Student;

@Mapper
public interface StudentMapper {
    List<Student> findAll();
    List<Student> findByName(String input);
    List<Student> findByDepartmentAndName(@Param("select") int select, @Param("input") String input);
}

