package com.cn.service;

import com.cn.model.Curriculum;

import java.util.List;

public interface CurriculumServiceI {

    void save(Curriculum model);

    void delete(Integer id);

    Curriculum view(Integer id);

    void update(Curriculum model);

    List<Curriculum> list();

}
