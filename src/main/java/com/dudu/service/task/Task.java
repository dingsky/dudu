package com.dudu.service.task;

import com.dudu.dao.redis.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.xml.ws.Response;

@Component
@EnableScheduling
@EnableAsync
public class Task {
//    public static Logger log = LoggerFactory.getLogger(Task.class);
//
//    @Async
//    @Scheduled(cron = "1 * * * * *")
//    public void taskone() {
//        log.info("taskone");
//    }
//
//    @Async
//    @Scheduled(fixedDelay = 1000)
//    public void tasktow() {
//        log.info("tasktwo");
//    }
}
