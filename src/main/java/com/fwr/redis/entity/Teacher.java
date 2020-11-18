package com.fwr.redis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Teacher
 * 
 * @author  fwr
 * @date 2020-11-17 
 */
@Data
@TableName("teacher")
public class Teacher {

	@TableId(type = IdType.AUTO)
	private Integer id;

	private String tName;

}
