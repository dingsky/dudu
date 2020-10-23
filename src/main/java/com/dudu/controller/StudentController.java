package com.dudu.controller;

import com.dudu.model.Student;
import com.dudu.service.StudentSevice;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/stu")
public class StudentController {
    @Resource
    private StudentSevice studentSevice;

    @RequestMapping(value = "/queryList", method = RequestMethod.GET)
    public List<Student>selectAllStudent() {
        return this.studentSevice.selectAll();
    }

    @PostMapping("/create")
    public String createStudent(@RequestBody Student student){
        this.studentSevice.createStudent(student);
        return "recv: "+student.getStudentNo()+student.getStudentName();
    }

    @GetMapping("/query")
    public Student queryOne(@RequestParam("studentNo") String studentNo){
        return this.studentSevice.selectOne(studentNo);
    }

    @PutMapping("/update")
    public String update(@RequestBody Student student){
        this.studentSevice.updateOne(student);
        return "success";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("studentNo") String studentNo){
        this.studentSevice.deleteOne(studentNo);
        return "success";
    }
}
