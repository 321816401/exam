package com.cn.action;

import com.cn.model.Classes;
import com.cn.model.Subject;
import com.cn.service.SubjectServiceI;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import javax.annotation.Resource;
import java.util.List;

@Results({@Result(name = "input", location = "add"),
        @Result(name = "list", type = "redirect", location = ""),
        @Result(name = "success", type = "redirect", location = "view/${id}"),
        @Result(name = "redirect", type = "redirect", location = "${redirect}")})
public class SubjectAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SubjectAction.class);

    private List<Subject> subjects;
    private Subject subject=new Subject();
    @Resource
	private SubjectServiceI subjectServiceI;


    public void save() {
        try {
            subjectServiceI.save(subject);
            super.success(null);
        } catch (Exception e) {
            super.fail();
            logger.error(e);
        }
    }

    public void delete() {
        try {
            subjectServiceI.delete(id);
            super.success(null);
        } catch (Exception e) {
            super.fail();
            logger.error(e);
        }
    }

    public void update() {
        try {
            subjectServiceI.update(subject);
            super.success(subject);
        } catch (Exception e) {
            super.fail();
            logger.error(e);
        }
    }

    public String list() {
        subjects = subjectServiceI.list();
        return "list";
    }

    public String question() {//根据题型查询题目
        subjects = subjectServiceI.question(subject.getQuestions().getId());
        return "list";
    }

    public String view() {
        subject=subjectServiceI.view(subject.getId());
        return "list";
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
