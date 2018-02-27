package com.cn.action;

import com.cn.model.Questions;
import com.cn.service.QuestionsServiceI;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import javax.annotation.Resource;
import java.util.List;

@Results({@Result(name = "input", location = "add"),
        @Result(name = "list", type = "redirect", location = ""),
        @Result(name = "success", type = "redirect", location = "view/${id}"),
        @Result(name = "redirect", type = "redirect", location = "${redirect}")})
public class QuestionsAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(QuestionsAction.class);

    private List<Questions> questionses;
    private Questions questions=new Questions();
    @Resource
	private QuestionsServiceI questionsServiceI;

    public void save() {
        try {
            questionsServiceI.save(questions);
            super.success(null);
        } catch (Exception e) {
            super.fail();
            logger.error(e);
        }
    }

    public void delete() {
        try {
            questionsServiceI.delete(id);
            super.success(null);
        } catch (Exception e) {
            super.fail();
            logger.error(e);
        }
    }

    public void update() {
        try {
            questionsServiceI.update(questions);
            super.success(questions);
        } catch (Exception e) {
            super.fail();
            logger.error(e);
        }
    }

    public String list() {
        questionses = questionsServiceI.list();
        return "list";
    }

    public String view() {
        questions=questionsServiceI.view(questions.getId());
        return "list";
    }


    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }

    public List<Questions> getQuestionses() {
        return questionses;
    }

    public void setQuestionses(List<Questions> questionses) {
        this.questionses = questionses;
    }
}
