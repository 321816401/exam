package com.cn.service.impl;

import com.cn.dao.BaseDaoI;
import com.cn.model.TestPaperSubject;
import com.cn.service.TestPaperSubjectServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service("testPaperSubjectServiceI")
public class TestPaperSubjectServiceImpl implements TestPaperSubjectServiceI {

	@Resource
	private BaseDaoI<TestPaperSubject> baseDao;

    @Override
    public void save(TestPaperSubject model) {
        baseDao.save(model);
    }

    @Override
    public void delete(Integer id) {
        TestPaperSubject model=baseDao.find("FROM TestPaperSubject where id="+id).get(0);
        baseDao.delete(model);
    }

    @Override
    public TestPaperSubject view(Integer id) {
        return baseDao.find("FROM TestPaperSubject where id="+id).get(0);
    }

    @Override
    public void update(TestPaperSubject model) {
         baseDao.update(model);
    }


    @Override
    public List<TestPaperSubject> list() {
        return baseDao.find("FROM TestPaperSubject");
    }

    @Override
    public List<TestPaperSubject> testPaper(Integer testPaperId) {
        return baseDao.find("FROM TestPaperSubject where testPaper.id="+testPaperId);
    }

    @Override
    public List<TestPaperSubject> check(Integer testPaperId,Integer subjectId) {
        return baseDao.find("FROM TestPaperSubject where testPaper.id="+testPaperId+" and subject.id ="+subjectId);
    }

}
