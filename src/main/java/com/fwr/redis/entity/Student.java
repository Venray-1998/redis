package com.fwr.redis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Student
 * 
 * @author  fwr
 * @date 2020-11-17 
 */
@Data
@TableName("student")
public class Student {

	@TableId(type = IdType.AUTO)
	private Integer id;

	private String sName;

	private String sBirth;

	private String sSex;

}
