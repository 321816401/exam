package com.cn.service;

import com.cn.model.Subject;

import java.util.List;

public interface SubjectServiceI {

    void save(Subject model);

    void delete(Integer id);

    void update(Subject model);

    List<Subject> list();

    List<Subject> question(Integer questionId);//根据题型查询

    Subject view(Integer id);


}
