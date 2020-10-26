package com.dudu.dao.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisUtilTest {
    public static final String testKey = "test_key";
    public static final String testValue = "test_value";
    public static final String testValue1 = "test_value1";

    private static Logger log = LoggerFactory.getLogger(RedisUtilTest.class);

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void test() {
        redisUtil.setRedisTemplate();

        redisUtil.set(testKey, testValue);
        assertEquals(redisUtil.get(testKey), testValue);
        redisUtil.update(testKey, testValue1);
        assertEquals(redisUtil.get(testKey), testValue1);
        redisUtil.delete(testKey);
        assertEquals(redisUtil.get(testKey), null);
    }
}