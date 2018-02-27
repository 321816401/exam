package com.cn.service.impl;

import com.cn.dao.BaseDaoI;
import com.cn.model.Curriculum;
import com.cn.service.CurriculumServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Transactional
@Service("curriculumServiceI")
public class CurriculumServiceImpl implements CurriculumServiceI {

	@Resource
	private BaseDaoI<Curriculum> baseDao;

    @Override
    public void save(Curriculum model) {
        baseDao.save(model);
    }

    @Override
    public void delete(Integer id) {
        Curriculum model=baseDao.find("FROM Curriculum where id="+id).get(0);
        baseDao.delete(model);
    }

    @Override
    public Curriculum view(Integer id) {
        return baseDao.find("FROM Curriculum where id="+id).get(0);
    }

    @Override
    public void update(Curriculum model) {
         baseDao.update(model);
    }


    @Override
    public List<Curriculum> list() {
        return baseDao.find("FROM Curriculum");
    }

}
