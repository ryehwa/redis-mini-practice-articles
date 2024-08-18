package com.redis.redis_mini_practice2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String, Integer> articleTemplate(
            RedisConnectionFactory redisConnectionFactory
    ) {
        RedisTemplate<String, Integer> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        //Key값 String으로 설정, 해당 코드 미작성 시 ��t article::1 이런 식으로 저장됨
        template.setKeySerializer(RedisSerializer.string());
        template.setValueSerializer(new GenericToStringSerializer<>(Integer.class));
        return template;
    }
}
