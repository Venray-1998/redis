package com.fwr.redis.entity;

import lombok.Data;

import java.util.List;

/**
 * @author fwr
 * @date 2020-11-19
 */
@Data
public class TestDTO {

    private Student student;

    private List<Teacher> teacher;

}
