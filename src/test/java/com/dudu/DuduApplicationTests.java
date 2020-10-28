package com.dudu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;

@SpringBootTest(classes = DuduApplication.class)
class DuduApplicationTests {
    @Resource
    DataSource dataSource;

    @Test
    void contextLoads() throws Exception{
        System.out.println(dataSource.getConnection());
    }

}
