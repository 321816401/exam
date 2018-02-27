package com.cn.service;

import com.cn.model.User;
import java.util.List;
import java.util.Map;

public interface UserServiceI{

    void save(User model);

    void delete(Integer id);

    void update(User model);

    List<User> list();

    List<User> students();//查询所有学生

    List<User> general();//查询所有不包含该管理员的用户

    User login(Map<String, Object> params);

}
