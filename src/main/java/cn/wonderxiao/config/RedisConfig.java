package cn.wonderxiao.config;

import cn.wonderxiao.model.User;
import cn.wonderxiao.util.FastJsonRedisSerializer;
import com.alibaba.fastjson.parser.ParserConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Created by xiaokai on 2018/10/11.
 */
@Configuration
public class RedisConfig {


    @Bean
    public RedisTemplate<String, User> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String, User> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        ParserConfig.getGlobalInstance().addAccept("cn.wonder.*");

        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());

        template.setValueSerializer(new FastJsonRedisSerializer<>(User.class));
        template.setHashValueSerializer(new FastJsonRedisSerializer<>(User.class));
        return template;
    }
}
