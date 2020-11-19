package com.fwr.redis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fwr.redis.annotation.CacheData;
import com.fwr.redis.entity.Student;
import com.fwr.redis.dao.StudentMapper;
import com.fwr.redis.entity.TestDTO;
import com.fwr.redis.service.TestService;
import com.fwr.redis.utils.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fwr
 * @date 2020-11-17
 */
@Service
@CacheConfig(cacheNames = "student")
public class TestServiceImpl implements TestService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private Test2 test2;

    @Override
    public ResultResponse<List<Student>> select() {
        List<Student> students = studentMapper.selectAll();
        return ResultResponse.toSuccessResult(students);
    }

    @Override
    //@Cacheable(key = "#id") //原生注解
    @CacheData(expireTime = 300, randomExpire = 10, keyPrefix = "111") //自定义注解
    public ResultResponse<TestDTO> selectOne(Integer id) {
        TestDTO test = test2.test(id);
        return ResultResponse.toSuccessResult(test);
    }

    @Override
    @CachePut(key = "#student.id")
    public ResultResponse<Integer> insert(Student student) {
        int insert = studentMapper.insert(student);
        return ResultResponse.toSuccessResult(insert);
    }

    @Override
    @CachePut(key = "#student.id")
    public ResultResponse<Integer> update(Student student) {
        int i = studentMapper.updateById(student);
        return ResultResponse.toSuccessResult(i);
    }

    @Override
    @CacheEvict(key = "#id")
    public ResultResponse<Integer> delete(Integer id) {
        int i = studentMapper.deleteById(id);
        return ResultResponse.toSuccessResult(i);
    }
}
