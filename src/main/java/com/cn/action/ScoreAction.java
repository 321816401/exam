package com.cn.action;

import com.cn.model.Score;
import com.cn.model.Subject;
import com.cn.service.ScoreServiceI;
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
public class ScoreAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ScoreAction.class);

    private List<Score> scores;
    private Score score=new Score();
    private String[] subjects;
    @Resource
    private ScoreServiceI scoreServiceI;
    @Resource
    private SubjectServiceI subjectServiceI;

    /**
     * 交卷，自动评分
     */
    public void save() {
        try {
            Integer number=0;
            for(String s:subjects){
               Integer subjectId= Integer.parseInt(s.substring(0,s.indexOf(",")));
                String answer=s.substring(s.indexOf(",")+1);
                Subject subject=subjectServiceI.view(subjectId);
                if(subject.getAnswer().equals(answer)){
                    number=number+subject.getScore();
                }
            }
            score.setNumber(number);
            scoreServiceI.save(score);
            super.success(null);
        } catch (Exception e) {
            super.fail();
            logger.error(e);
        }
    }



    public String list() {
        scores = scoreServiceI.list(score.getUser().getId());
        return "list";
    }

    public String view() {
        score=scoreServiceI.view(score.getId());
        return "list";
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }
}
