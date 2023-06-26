package com.example.account.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisRepositoryConfig {
    @Value("${spring.redis.host}")  // application.yml에 등록했던 정보
    private String redisHost;

    @Value("${spring.redis.port}")  // application.yml에 등록했던 정보
    private int redisPort;

    @Bean
    public RedissonClient redissonClient() { // 하나의 redissonClient를 bean으로 등록
        Config config = new Config();
        config.useSingleServer().setAddress("redis://" + redisHost + ":" + redisPort);

        return Redisson.create(config);
    }
}
