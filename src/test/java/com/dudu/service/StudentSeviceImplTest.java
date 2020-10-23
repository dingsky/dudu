package com.dudu.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentSeviceImplTest {

    Logger log = LoggerFactory.getLogger(StudentSeviceImplTest.class);

    @Resource
    private StudentSevice studentSevice;

    @Test
    public void testSelectAll(){
        studentSevice.selectAll();
        log.info("test===================");
    }
}