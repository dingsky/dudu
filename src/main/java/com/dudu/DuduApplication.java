package com.dudu;

import com.dudu.config.SysEnv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DuduApplication {

    public static void main(String[] args) {
        System.out.println( SysEnv.nacosServ);
        SpringApplication.run(DuduApplication.class, args);
    }

}
