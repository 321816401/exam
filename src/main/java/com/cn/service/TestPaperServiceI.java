package com.cn.service;

import com.cn.model.TestPaper;

import java.util.List;

public interface TestPaperServiceI {

    void save(TestPaper model);

    void delete(Integer id);

    void update(TestPaper model);

    List<TestPaper> list();

    TestPaper view(Integer id);



}
