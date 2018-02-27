package com.cn.service;

import com.cn.model.Score;

import java.util.List;

public interface ScoreServiceI {

    void save(Score model);

    void delete(Integer id);

    void update(Score model);

    List<Score> list(Integer userId);

    Score view(Integer id);




}
