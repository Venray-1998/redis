package com.fwr.redis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author fwr
 * @date 2020-11-17
 */
@Data
public class User implements Serializable {

    private String name;
    private String age;

}
