package com.cn.action;

import com.cn.model.TestPaperSubject;
import com.cn.service.TestPaperSubjectServiceI;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import javax.annotation.Resource;
import java.util.List;

@Results({@Result(name = "input", location = "add"),
        @Result(name = "list", type = "redirect", location = ""),
        @Result(name = "success", type = "redirect", location = "view/${id}"),
        @Result(name = "redirect", type = "redirect", location = "${redirect}")})
public class TestPaperSubjectAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(TestPaperSubjectAction.class);

    private List<TestPaperSubject> testPaperSubjects;
    private TestPaperSubject testPaperSubject=new TestPaperSubject();
    @Resource
	private TestPaperSubjectServiceI testPaperSubjectServiceI;


    public void save() {
        try {
            testPaperSubjectServiceI.save(testPaperSubject);
            super.success(null);
        } catch (Exception e) {
            super.fail();
            logger.error(e);
        }
    }

    public void delete() {
        try {
            testPaperSubjectServiceI.delete(id);
            super.success(null);
        } catch (Exception e) {
            super.fail();
            logger.error(e);
        }
    }

    public void update() {
        try {
            testPaperSubjectServiceI.update(testPaperSubject);
            super.success(testPaperSubject);
        } catch (Exception e) {
            super.fail();
            logger.error(e);
        }
    }

    public String list() {
        testPaperSubjects = testPaperSubjectServiceI.list();
        return "list";
    }

    public String testPaper() {//根据试卷查询所有题目
        testPaperSubjects = testPaperSubjectServiceI.testPaper(testPaperSubject.getTestPaper().getId());
        return "list";
    }

    public String view() {
        testPaperSubject=testPaperSubjectServiceI.view(testPaperSubject.getId());
        return "list";
    }

    public List<TestPaperSubject> getTestPaperSubjects() {
        return testPaperSubjects;
    }

    public void setTestPaperSubjects(List<TestPaperSubject> testPaperSubjects) {
        this.testPaperSubjects = testPaperSubjects;
    }

    public TestPaperSubject getTestPaperSubject() {
        return testPaperSubject;
    }

    public void setTestPaperSubject(TestPaperSubject testPaperSubject) {
        this.testPaperSubject = testPaperSubject;
    }
}
