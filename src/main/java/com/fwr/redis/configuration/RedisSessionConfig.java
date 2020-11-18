package com.fwr.redis.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author fwr
 * @date 2020-11-18
 */
@Configuration
@EnableRedisHttpSession(redisNamespace = "redis:session")
public class RedisSessionConfig {
}
