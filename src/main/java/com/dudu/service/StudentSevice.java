package com.dudu.service;

import com.dudu.model.Student;

import java.util.List;

public interface StudentSevice {
    List<Student> selectAll();
    void createStudent(Student student);
    Student selectOne(String studentNo);
    void updateOne(Student student);
    void deleteOne(String student);
}
