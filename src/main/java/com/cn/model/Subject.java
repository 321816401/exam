package com.cn.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 题目表
 */
@Entity
@Table(name = "subject", catalog = "exam")
public class Subject implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = true, length = 11)
	private Integer id;

    @Column(name = "title", nullable = false, length = 20)
    private String title="";//题目名称

    @Column(name = "optionA", nullable = false, length = 20)
    private String optionA="";//题目选项a

    @Column(name = "optionB", nullable = false, length = 20)
    private String optionB="";//题目选项b

    @Column(name = "optionC", nullable = false, length = 20)
    private String optionC="";//题目选项c

    @Column(name = "score", nullable = false, length = 20)
    private Integer score=0;//题目分值

    @Column(name = "answer", nullable = false, length = 20)
	private String answer="";//题目答案

    @Column(name = "addTime", nullable = false, length = 0)
	private Date addTime=new Date();//创建时间

    @Column(name = "updateTime", nullable = false, length = 0)
    private Date updateTime=new Date();//更新时间

    @OneToOne(targetEntity = Questions.class)
    @JoinColumn(name = "questionsId")
    private Questions questions;//题目类型



	public Subject() {
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }
}