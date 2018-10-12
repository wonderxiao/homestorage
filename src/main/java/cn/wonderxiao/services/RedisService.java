package cn.wonderxiao.services;

import cn.wonderxiao.model.User;

import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Created by xiaokai on 2018/10/11.
 */
public interface RedisService {
    public void add(User user);
    public User get(String id);
    public void update(String id, String name, Integer age);
    public void delete(String id);
    public List<User> getAllUser();
}
