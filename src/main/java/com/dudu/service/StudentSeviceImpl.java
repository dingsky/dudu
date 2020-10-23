package com.dudu.service;

import com.dudu.dao.StudentMapper;
import com.dudu.model.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("studentSevice")
public class StudentSeviceImpl implements StudentSevice{

    @Resource
    private StudentMapper studentMapper;

    @Override
    public List<Student> selectAll() {
        return this.studentMapper.selectAll();
    }

    @Override
    public void createStudent(Student student) {
        this.studentMapper.insert(student);
    }

    @Override
    public Student selectOne(String studentNo) {
        return this.studentMapper.selectOne(studentNo);
    }

    @Override
    public void updateOne(Student student) {
        this.studentMapper.updateOne(student);
    }

    @Override
    public void deleteOne(String studentNo) {
       this.studentMapper.deleteOne(studentNo);
    }
}
