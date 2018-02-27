package com.cn.service.impl;

import com.cn.dao.BaseDaoI;
import com.cn.model.Classes;
import com.cn.service.ClassesServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Transactional
@Service("classesServiceI")
public class ClassesServiceImpl implements ClassesServiceI {

	@Resource
	private BaseDaoI<Classes> baseDao;

    @Override
    public void save(Classes model) {
        baseDao.save(model);
    }

    @Override
    public void delete(Integer id) {
        Classes model=baseDao.find("FROM Classes where id="+id).get(0);
        baseDao.delete(model);
    }

    @Override
    public Classes view(Integer id) {
        return baseDao.find("FROM Classes where id="+id).get(0);
    }

    @Override
    public void update(Classes model) {
         baseDao.update(model);
    }

    @Override
    public List<Classes> list() {
        return baseDao.find("FROM Classes");
    }


}
