package com.cn.service;

import com.cn.model.Questions;

import java.util.List;

public interface QuestionsServiceI {

    void save(Questions model);

    void delete(Integer id);

    void update(Questions model);

    List<Questions> list();


    Questions view(Integer id);


}
