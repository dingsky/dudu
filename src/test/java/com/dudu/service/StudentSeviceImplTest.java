package com.dudu.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentSeviceImplTest {
    @Resource
    private StudentSevice studentSevice;

    @Test
    public void testSelectAll(){
        System.out.println(studentSevice.selectAll());
    }
}