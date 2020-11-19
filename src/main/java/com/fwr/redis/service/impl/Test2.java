package com.fwr.redis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fwr.redis.annotation.CacheData;
import com.fwr.redis.dao.StudentMapper;
import com.fwr.redis.entity.Student;
import com.fwr.redis.entity.Teacher;
import com.fwr.redis.entity.TestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author fwr
 * @date 2020-11-19
 */
@Service
public class Test2 {

    @Autowired
    private StudentMapper studentMapper;

    //@CacheData(expireTime = 300, randomExpire = 10, keyPrefix = "111")
    public TestDTO test(Integer id) {
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Student::getId, id);
        Student student = studentMapper.selectOne(wrapper);
        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setName("t");
        ArrayList<Teacher> list = new ArrayList<>();
        list.add(teacher);
        TestDTO testDTO = new TestDTO();
        testDTO.setStudent(student);
        testDTO.setTeacher(list);
        return testDTO;
    }
}
