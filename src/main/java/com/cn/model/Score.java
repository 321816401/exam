package com.cn.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 成绩表
 */
@Entity
@Table(name = "score", catalog = "exam")
public class Score implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, length = 11)
	private Integer id;

    @Column(name = "number", nullable = false, length = 20)
	private Integer number=0;//分数

    @Column(name = "addTime", nullable = false, length = 0)
	private Date addTime=new Date();//创建时间

    @Column(name = "updateTime", nullable = false, length = 0)
    private Date updateTime=new Date();//更新时间

    @OneToOne(targetEntity = TestPaper.class)
    @JoinColumn(name = "testPaperId")
    private TestPaper testPaper;//试卷外键

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "userId")
    private User user;//学生外键



	public Score() {
	}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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

    public TestPaper getTestPaper() {
        return testPaper;
    }

    public void setTestPaper(TestPaper testPaper) {
        this.testPaper = testPaper;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}