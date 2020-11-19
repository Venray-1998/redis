package com.fwr.redis.service;

import com.fwr.redis.entity.Student;
import com.fwr.redis.entity.TestDTO;
import com.fwr.redis.utils.ResultResponse;

import java.sql.ResultSet;
import java.util.List;

/**
 * @author fwr
 * @date 2020-11-17
 */
public interface TestService {

    ResultResponse<List<Student>> select();

    ResultResponse<TestDTO> selectOne(Integer id);

    ResultResponse<Integer> insert(Student student);

    ResultResponse<Integer> update(Student student);

    ResultResponse<Integer> delete(Integer id);
}
