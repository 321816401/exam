package com.cn.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 试卷题目关联关系表
 */
@Entity
@Table(name = "testPaperSubject", catalog = "exam")
public class TestPaperSubject implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    private Integer id;

    @OneToOne(targetEntity = TestPaper.class)
    @JoinColumn(name = "testPaperId")
    private TestPaper testPaper;//试卷外键

    @OneToOne(targetEntity = Subject.class)
    @JoinColumn(name = "subjectId")
    private Subject subject;//题目外键



    public TestPaperSubject() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TestPaper getTestPaper() {
        return testPaper;
    }

    public void setTestPaper(TestPaper testPaper) {
        this.testPaper = testPaper;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}