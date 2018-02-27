package com.cn.service;


import com.cn.model.TestPaperSubject;

import java.util.List;

public interface TestPaperSubjectServiceI {

    void save(TestPaperSubject model);

    void delete(Integer id);

    void update(TestPaperSubject model);

    List<TestPaperSubject> list();

    List<TestPaperSubject> testPaper(Integer testPaperId);//根据试卷查询所有题目

    List<TestPaperSubject> check(Integer testPaperId,Integer subjectId);//根据试卷和题目查询对象

    TestPaperSubject view(Integer id);



}
