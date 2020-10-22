package com.dudu.controller;

import com.dudu.domain.Student;
import com.dudu.service.StudentSevice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/stu")
public class StudentController {
    @Resource
    private StudentSevice studentSevice;

    @RequestMapping(value = "/get.do", method = RequestMethod.GET)
    public List<Student>selectAllStudent() {
        return this.studentSevice.selectAll();
    }
}
