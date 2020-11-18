package com.fwr.redis.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fwr.redis.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author fwr
 * @date 2020-11-17
 */
@Repository
public interface StudentMapper extends BaseMapper<Student> {

    List<Student> selectAll();
}
