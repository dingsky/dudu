package com.dudu.dao.redis;

import com.mysql.cj.log.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;

@Component
public class RedisUtil {
    Logger log = LoggerFactory.getLogger(RedisUtil.class);

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Autowired(required = false)
    public void setRedisTemplate() {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        this.redisTemplate.setKeySerializer(stringSerializer);
        this.redisTemplate.setValueSerializer(stringSerializer);
    }

    public void set(String key, String value) {
        if (redisTemplate == null) {
            log.error("redisTemplate is null");
            return;
        }
        ValueOperations<String, String> vo = this.redisTemplate.opsForValue();
        vo.set(key, value);
    }

    public String get(String key) {
        ValueOperations<String, String> vo = this.redisTemplate.opsForValue();
        return vo.get(key);
    }

    public void update(String key, String value) {
        ValueOperations<String, String> vo = this.redisTemplate.opsForValue();
        vo.set(key, value);
    }

    public void delete(String key) {
        ValueOperations<String, String> vo = this.redisTemplate.opsForValue();
        vo.getOperations().delete(key);
    }
}
