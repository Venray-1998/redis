package com.fwr.redis.service;

import com.fwr.redis.entity.Student;
import com.fwr.redis.utils.ResultResponse;

import java.util.List;

/**
 * @author fwr
 * @date 2020-11-17
 */
public interface TestService {

    ResultResponse<List<Student>> select();
}
