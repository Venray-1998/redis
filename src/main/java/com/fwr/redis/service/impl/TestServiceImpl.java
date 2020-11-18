package com.fwr.redis.service.impl;

import com.fwr.redis.entity.Student;
import com.fwr.redis.dao.StudentMapper;
import com.fwr.redis.service.TestService;
import com.fwr.redis.utils.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fwr
 * @date 2020-11-17
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public ResultResponse<List<Student>> select() {
        List<Student> students = studentMapper.selectAll();
        return ResultResponse.toSuccessResult(students);
    }
}
