package com.fwr.redis.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fwr.redis.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author fwr
 * @date 2020-11-17
 */
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {
}
