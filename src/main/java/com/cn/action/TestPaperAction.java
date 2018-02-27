package com.cn.action;

import com.cn.model.Subject;
import com.cn.model.TestPaper;
import com.cn.model.TestPaperSubject;
import com.cn.service.SubjectServiceI;
import com.cn.service.TestPaperServiceI;
import com.cn.service.TestPaperSubjectServiceI;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Results({@Result(name = "input", location = "add"),
        @Result(name = "list", type = "redirect", location = ""),
        @Result(name = "success", type = "redirect", location = "view/${id}"),
        @Result(name = "redirect", type = "redirect", location = "${redirect}")})
public class TestPaperAction extends BaseAction {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(TestPaperAction.class);

    private List<TestPaper> testPapers;
    private TestPaper testPaper = new TestPaper();
    @Resource
    private TestPaperServiceI testPaperServiceI;
    @Resource
    private TestPaperSubjectServiceI testPaperSubjectServiceI;
    @Resource
    private SubjectServiceI subjectServiceI;


    public void save() {
        try {
            testPaperServiceI.save(testPaper);
            super.success(testPaper);
        } catch (Exception e) {
            super.fail();
            logger.error(e);
        }

    }

    /**
     * 自动生成题目
     */
    public void subject() {
        try {
            List<Subject> subjects = subjectServiceI.list();
            List<Subject> list = new ArrayList<>();//题库随机集合
            Random random = new Random();
            int r;
            testPaper = testPaperServiceI.view(testPaper.getId());
            Integer subjectNum = testPaper.getSubjectNum(), score = testPaper.getScore();
            for (Subject subject : subjects) {
                r = random.nextInt(subjects.get(subjects.size() - 1).getId() + 1);
                if (list.size() < 11 && !list.contains(subject) &&testPaperSubjectServiceI.check(testPaper.getId(),subject.getId()).isEmpty()&&r == subject.getId()) {//一次最多生成10条，并且不重复，并且是题目
                    list.add(subject);
                    TestPaperSubject tps = new TestPaperSubject();
                    subjectNum++;
                    score = score + subject.getScore();
                    tps.setSubject(subject);
                    tps.setTestPaper(testPaper);
                    testPaperSubjectServiceI.save(tps);
                }
            }
            testPaper.setScore(score);
            testPaper.setSubjectNum(subjectNum);
            testPaperServiceI.update(testPaper);
            super.success(null);
        } catch (Exception e) {
            super.fail();
            logger.error(e);
        }
    }



    public void delete() {
        try {
            testPaperServiceI.delete(id);
            super.success(null);
        } catch (Exception e) {
            super.fail();
            logger.error(e);
        }
    }

    public void update() {
        try {
            testPaperServiceI.update(testPaper);
            super.success(testPaper);
        } catch (Exception e) {
            super.fail();
            logger.error(e);
        }
    }

    public String list() {
        testPapers = testPaperServiceI.list();
        return "list";
    }

    public String view() {
        testPaper = testPaperServiceI.view(testPaper.getId());
        return "list";
    }

    public TestPaper getTestPaper() {
        return testPaper;
    }

    public void setTestPaper(TestPaper testPaper) {
        this.testPaper = testPaper;
    }

    public List<TestPaper> getTestPapers() {
        return testPapers;
    }

    public void setTestPapers(List<TestPaper> testPapers) {
        this.testPapers = testPapers;
    }
}
