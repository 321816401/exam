package com.cn.service.impl;

import com.cn.dao.BaseDaoI;
import com.cn.model.User;
import com.cn.service.UserServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Transactional
@Service("userServiceI")
public class UserServiceImpl implements UserServiceI {

	@Resource
	private BaseDaoI<User> baseDao;

    @Override
    public void save(User model) {
        baseDao.save(model);
    }

    @Override
    public void delete(Integer id) {
        User model=baseDao.find("FROM User as u where id="+id).get(0);
        baseDao.delete(model);
    }

    @Override
    public void update(User model) {
        baseDao.update(model);
    }


    @Override
    public List<User> list() {
        return baseDao.find("FROM User");
    }

    @Override
    public List<User> students() {
        return baseDao.find("FROM User where type = 2");
    }

    @Override
    public List<User> general() {
        return baseDao.find("FROM User where type <> 3");
    }


    @Override
    public User login( Map<String, Object> params) {
        User user;
        try {
            user=baseDao.login(params).get(0);
        }catch (Exception e){
            return null;
        }
        return user;
    }
}
