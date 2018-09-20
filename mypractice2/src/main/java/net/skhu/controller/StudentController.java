package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.dto.Department;
import net.skhu.dto.Student;
import net.skhu.mapper.DepartmentMapper;
import net.skhu.mapper.StudentMapper;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired StudentMapper studentMapper;
    @Autowired DepartmentMapper departmentMapper;
    
    @RequestMapping("list")
    public String list(Model model) {
        List<Student> students = studentMapper.findAll();
        List<Department> departments = departmentMapper.findAll();
        model.addAttribute("students", students);
        model.addAttribute("departments", departments);
        model.addAttribute("select",0);
        return "student/list";
    }
    
    
    @RequestMapping(value="list", method=RequestMethod.POST)
    public String list(Model model, @RequestParam("select") int select, @RequestParam("input") String input) {
    	List<Student> students = select==0?studentMapper.findByName(input+"%"):studentMapper.findByDepartmentAndName(select,input+"%");
    	model.addAttribute("students", students);
    	List<Department> departments = departmentMapper.findAll();
    	model.addAttribute("departments", departments);
    	model.addAttribute("select",select);
        return "student/list";
    }
}

