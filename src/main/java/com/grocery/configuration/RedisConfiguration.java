package com.grocery.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport {

    Logger logger = LoggerFactory.getLogger(RedisConfiguration.class);

    @Value("${spring.cache.host}")
    private String host;

    @Value("${spring.cache.port}")
    private int port;

    @Value("${spring.cache.timeout}")
    private int timeout;

    @Value("${spring.cache.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.cache.pool.max-wait}")
    private long maxWaitMillis;

    @Value("${spring.cache.password}")
    private String password;

    @Bean
    public JedisPool redisPoolFactory() {
        logger.info("JedisPool注入成功！！");
        logger.info("redis地址：" + host + ":" + port);
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);

        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password);

        return jedisPool;
    }

}
