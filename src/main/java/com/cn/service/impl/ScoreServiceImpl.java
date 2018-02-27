package com.cn.service.impl;

import com.cn.dao.BaseDaoI;
import com.cn.model.Score;
import com.cn.service.ScoreServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Transactional
@Service("scoreServiceI")
public class ScoreServiceImpl implements ScoreServiceI {

	@Resource
	private BaseDaoI<Score> baseDao;

    @Override
    public void save(Score model) {
        baseDao.save(model);
    }

    @Override
    public void delete(Integer id) {
        Score model=baseDao.find("FROM Score where id="+id).get(0);
        baseDao.delete(model);
    }

    @Override
    public void update(Score model) {
         baseDao.update(model);
    }

    @Override
    public Score view(Integer id) {
        return baseDao.find("FROM Score where id="+id).get(0);
    }

    @Override
    public List<Score> list(Integer userId) {
        return baseDao.find("FROM Score where user.id="+userId);
    }

}
