package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.domain.Student;
import net.skhu.repository.StudentRepository;

@RestController
public class HomeController {

    @Autowired StudentRepository studentRepository;

    @RequestMapping("/students")
    public List<Student> students() {
        return studentRepository.findAll();
    }

}
