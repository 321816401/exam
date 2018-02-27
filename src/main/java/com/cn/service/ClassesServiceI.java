package com.cn.service;

import com.cn.model.Classes;

import java.util.List;

public interface ClassesServiceI {

    void save(Classes model);

    void delete(Integer id);

    void update(Classes model);

    List<Classes> list();

    Classes view(Integer id);


}
