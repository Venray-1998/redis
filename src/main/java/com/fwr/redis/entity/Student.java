package com.fwr.redis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Student
 *
 * @author fwr
 * @date 2020-11-17
 */
@Data
@TableName("student")
public class Student implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private String birth;

    private String sex;

}
