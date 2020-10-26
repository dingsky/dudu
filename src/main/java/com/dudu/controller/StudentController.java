package com.dudu.controller;

import com.dudu.dao.redis.RedisUtil;
import com.dudu.model.Student;
import com.dudu.service.StudentSevice;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/stu")
public class StudentController {

    public static Logger log = LoggerFactory.getLogger(StudentController.class);

    @Resource
    private StudentSevice studentSevice;

    @RequestMapping(value = "/queryList", method = RequestMethod.GET)
    public PageInfo<Student>selectAllStudent(@RequestParam("page") Integer page,@RequestParam("size") Integer size) {
        PageHelper.startPage(page,size);
        List<Student> list;
        try {
            list = this.studentSevice.selectAll();
        }catch (Exception e){
            log.error("selectAllStudent exception:"+ e.toString());
            list = null;
        }
        PageInfo<Student> pageInfo = new PageInfo<>(list);
        return pageInfo;
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
