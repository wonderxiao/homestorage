package cn.wonderxiao.services.impl;

import cn.wonderxiao.model.User;
import cn.wonderxiao.services.RedisService;
import cn.wonderxiao.util.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Created by xiaokai on 2018/10/11.
 */
@Service
public class RedisServiceImpl implements RedisService {
    private static final Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);
    @Autowired
    private User user;
    @Resource
    private RedisTemplate<String, User> redisTemplate;

    @Override
    public List<User> getAllUser() {
        Set<String> keys = redisTemplate.keys("*");
        ValueOperations<String, User> vo = redisTemplate.opsForValue();
        List<User> userList = new ArrayList<>();
        for (String key: keys){
            logger.info("user info is ",key);
            //logger.info(String.valueOf(key));
            userList.add(vo.get(key));
        }
        return userList;
    }

    @Override
    public void add(User user) {
        ValueOperations<String, User> vo = redisTemplate.opsForValue();
        logger.info("user info is ",user.getId(),user.getName(),user.getAge());
        vo.set(user.getId(),user);
    }

    @Override
    public User get(String id) {
        ValueOperations<String,User> vo = redisTemplate.opsForValue();
        logger.info("user id is ",id);
        return vo.get(id);
    }

    @Override
    public void update(String id, String name, Integer age) {
        ValueOperations<String,User> vo = redisTemplate.opsForValue();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        logger.info("update user info is ",id,name,age);
        vo.set(id,user);
    }

    @Override
    public void delete(String id) {
        ValueOperations<String,User> vo = redisTemplate.opsForValue();
        logger.info("delete user info is starting...\n id is ",id);
        vo.getOperations().delete(id);
    }
}
