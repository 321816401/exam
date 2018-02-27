package com.cn.action;

import com.cn.model.Curriculum;
import com.cn.service.CurriculumServiceI;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

//课程方法
@Results({@Result(name = "input", location = "add"),
        @Result(name = "list", type = "redirect", location = ""),
        @Result(name = "success", type = "redirect", location = "view/${id}"),
        @Result(name = "redirect", type = "redirect", location = "${redirect}")})
public class CurriculumAction extends BaseAction {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(CurriculumAction.class);

    private Curriculum curriculum=new Curriculum();
    private List<Curriculum> curriculums=new ArrayList<>();

    @Resource
    private CurriculumServiceI curriculumServiceI;

    public void save() {
        try {
            curriculumServiceI.save(curriculum);
            super.success(null);
        } catch (Exception e) {
            super.fail();
            logger.error(e);
        }
    }

    public void delete() {
        try {
            curriculumServiceI.delete(id);
            super.success(null);
        } catch (Exception e) {
            super.fail();
            logger.error(e);
        }
    }

    public void update() {
        try {
            curriculumServiceI.update(curriculum);
            super.success(curriculum);
        } catch (Exception e) {
            super.fail();
            logger.error(e);
        }
    }

    public String list() {
        curriculums = curriculumServiceI.list();
        return "list";
    }

    public String view() {
        curriculum=curriculumServiceI.view(curriculum.getId());
        return "list";
    }


    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    public List<Curriculum> getCurriculums() {
        return curriculums;
    }

    public void setCurriculums(List<Curriculum> curriculums) {
        this.curriculums = curriculums;
    }
}
