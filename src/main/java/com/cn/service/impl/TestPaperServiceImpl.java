package com.cn.service.impl;

import com.cn.dao.BaseDaoI;
import com.cn.model.TestPaper;
import com.cn.service.TestPaperServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Transactional
@Service("testPaperServiceI")
public class TestPaperServiceImpl implements TestPaperServiceI {

	@Resource
	private BaseDaoI<TestPaper> baseDao;

    @Override
    public void save(TestPaper model) {
        baseDao.save(model);
    }

    @Override
    public void delete(Integer id) {
        TestPaper model=baseDao.find("FROM TestPaper where id="+id).get(0);
        baseDao.delete(model);
    }

    @Override
    public TestPaper view(Integer id) {
        return baseDao.find("FROM TestPaper where id="+id).get(0);
    }

    @Override
    public void update(TestPaper model) {
         baseDao.update(model);
    }


    @Override
    public List<TestPaper> list() {
        return baseDao.find("FROM TestPaper");
    }

}
