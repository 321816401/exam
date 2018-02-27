package com.cn.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 试卷表
 */
@Entity
@Table(name = "testPaper", catalog = "exam")
public class TestPaper implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    private Integer id;

    @Column(name = "name", nullable = false, length = 20)
    private String name="";//名称

    @Column(name = "addTime", nullable = false, length = 0)
    private Date addTime=new Date();//创建时间

    @Column(name = "updateTime", nullable = false, length = 0)
    private Date updateTime=new Date();//更新时间

    @Column(name = "subjectNum", nullable = false, length = 20)
    private Integer subjectNum=0;//题目数

    @Column(name = "score", nullable = false, length = 20)
    private Integer score=0;//总分数

    @OneToOne(targetEntity = Curriculum.class)
    @JoinColumn(name = "curriculumId")
    private Curriculum curriculum;//课程外键

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "userId")
    private User user;//老师外键


    public TestPaper() {
    }



    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Date getAddTime() {
        return addTime;
    }
    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getSubjectNum() {
        return subjectNum;
    }

    public void setSubjectNum(Integer subjectNum) {
        this.subjectNum = subjectNum;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}