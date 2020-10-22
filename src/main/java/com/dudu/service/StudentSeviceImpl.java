package com.dudu.service;

import com.dudu.domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentSevice")
public class StudentSeviceImpl implements StudentSevice{
    @Override
    public List<Student> selectAll() {
        return null;
    }
}
