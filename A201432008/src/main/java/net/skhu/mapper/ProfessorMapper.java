package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.Professor;
import net.skhu.dto.Student;

@Mapper
public interface ProfessorMapper {
	List<Professor> findAll();
	List<Professor> findByDepartmentId(int departmentId);
	Professor findOne(int id);
}
