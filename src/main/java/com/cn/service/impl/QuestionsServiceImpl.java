package com.cn.service.impl;

import com.cn.dao.BaseDaoI;
import com.cn.model.Questions;
import com.cn.service.QuestionsServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Transactional
@Service("questionsServiceI")
public class QuestionsServiceImpl implements QuestionsServiceI {

	@Resource
	private BaseDaoI<Questions> baseDao;

    @Override
    public void save(Questions model) {
        baseDao.save(model);
    }

    @Override
    public void delete(Integer id) {
        Questions model=baseDao.find("FROM Questions where id="+id).get(0);
        baseDao.delete(model);
    }

    @Override
    public void update(Questions model) {
         baseDao.update(model);
    }

    @Override
    public Questions view(Integer id) {
        return baseDao.find("FROM Questions where id="+id).get(0);
    }


    @Override
    public List<Questions> list() {
        return baseDao.find("FROM Questions");
    }

}
