package com.fwr.redis;

import com.fwr.redis.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.StringReader;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest(classes = RedisApplication.class)
@RunWith(SpringRunner.class)
class RedisApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void redisTemplateTest() {
        User aa = (User) redisTemplate.opsForValue().get("aa");
        System.out.println(aa);
    }

    @Test
    void contextLoads() {

        BoundValueOperations<String, String> time1 = stringRedisTemplate.boundValueOps("time");
        String s = time1.get();
        System.out.println(s);

        Set<String> keys = stringRedisTemplate.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
    }

}
