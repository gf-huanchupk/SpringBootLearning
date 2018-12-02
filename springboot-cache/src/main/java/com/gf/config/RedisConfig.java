package com.gf.config;


        import com.alibaba.fastjson.parser.ParserConfig;
        import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.data.redis.cache.RedisCacheConfiguration;
        import org.springframework.data.redis.cache.RedisCacheManager;
        import org.springframework.data.redis.connection.RedisConnectionFactory;
        import org.springframework.data.redis.core.RedisTemplate;
        import org.springframework.data.redis.serializer.RedisSerializationContext;
        import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        GenericFastJsonRedisSerializer serializer = new GenericFastJsonRedisSerializer();

        ParserConfig.getGlobalInstance().addAccept("com.gf.");

        //key序列化方式
        template.setKeySerializer(new StringRedisSerializer());
        //value序列化
        template.setValueSerializer(serializer);
        //value hashmap序列化
        template.setHashValueSerializer(serializer);
        template.afterPropertiesSet();

        return template;
    }

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {

        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();

        GenericFastJsonRedisSerializer serializer = new GenericFastJsonRedisSerializer();

        ParserConfig.getGlobalInstance().addAccept("com.gf.");

        config = config.serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serializer))
                .disableCachingNullValues();

        RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(config);


        return builder.build();
    }


}
