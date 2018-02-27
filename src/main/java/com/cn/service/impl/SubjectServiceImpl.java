package com.cn.service.impl;

import com.cn.dao.BaseDaoI;
import com.cn.model.Classes;
import com.cn.model.Subject;
import com.cn.service.ClassesServiceI;
import com.cn.service.SubjectServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Transactional
@Service("subjectServiceI")
public class SubjectServiceImpl implements SubjectServiceI {

	@Resource
	private BaseDaoI<Subject> baseDao;

    @Override
    public void save(Subject model) {
        baseDao.save(model);
    }

    @Override
    public void delete(Integer id) {
        Subject model=baseDao.find("FROM Subject where id="+id).get(0);
        baseDao.delete(model);
    }

    @Override
    public Subject view(Integer id) {
        return baseDao.find("FROM Subject where id="+id).get(0);
    }

    @Override
    public void update(Subject model) {
         baseDao.update(model);
    }

    @Override
    public List<Subject> list() {
        return baseDao.find("FROM Subject");
    }

    @Override
    public List<Subject> question(Integer questionId) {
        return baseDao.find("FROM Subject where question.id="+questionId);
    }

}
