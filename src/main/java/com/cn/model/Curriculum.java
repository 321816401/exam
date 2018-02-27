package com.cn.model;

import javax.persistence.*;
import java.util.Date;

/**
 * 课程表
 */
@Entity
@Table(name = "curriculum", catalog = "exam")
public class Curriculum implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, length = 11)
	private Integer id;

    @Column(name = "name", nullable = false, length = 40)
	private String name="";//名称

    @Column(name = "content", nullable = false, length = 300)
    private String content="";//介绍

    @Column(name = "addTime", nullable = false, length = 0)
	private Date addTime=new Date();//创建时间

    @Column(name = "updateTime", nullable = false, length = 0)
    private Date updateTime=new Date();//更新时间

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "userId")
    private User user;//老师外键

	public Curriculum() {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}