package com.fwr.redis.annotation;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * 序列化工具类
 *
 * @author mengq
 */
@Component
public class SerializableUtil {

    private final GenericFastJsonRedisSerializer genericFastJsonRedisSerializer = new GenericFastJsonRedisSerializer();

    /**
     * 序列化
     *
     * @param obj 序列化对象
     * @throws NotSerializableException 类无实现序列化异常
     */
    public byte[] serialize(Object obj) {
        return genericFastJsonRedisSerializer.serialize(obj);
    }

    /**
     * 序列化
     *
     * @param obj          序列化对象
     * @param defaultValue 对象序列化失败后默认值
     * @throws NotSerializableException 类无实现序列化异常
     */
    public byte[] serialize(Object obj, Object defaultValue) {
        if (null == obj) {
            return null;
        }
        byte[] serializeValue = serialize(obj);
        if (null == serializeValue) {
            return serialize(defaultValue);
        }
        return serializeValue;
    }

    /**
     * 反序列化
     *
     * @param value
     */
    public Object deserialize(byte[] value) {
        return genericFastJsonRedisSerializer.deserialize(value);
    }
}
