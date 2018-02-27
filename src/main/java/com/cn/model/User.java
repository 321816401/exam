package com.cn.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 用户表
 */
@Entity
@Table(name = "user", catalog = "exam")
public class User implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = true, length = 11)
	private Integer id;

    @Column(name = "account", nullable = false, length = 40)
    private String account="";//账号

    @Column(name = "pazzword", nullable = false, length = 40)
    private String pazzword="";//密码

    @Column(name = "type", nullable = false, length = 10)
    private Integer type=1;//用户类型（0：管理员；1：老师；2：学生）

    @Column(name = "name", nullable = false, length = 40)
	private String name="";//姓名

    @Column(name = "code", nullable = false, length = 40)
    private String code="";//老师编号/学生学号

    @Column(name = "sex", nullable = false, length = 10)
    private String sex="";//性别

    @Column(name = "addTime", nullable = false, length = 0)
	private Date addTime=new Date();//创建时间

    @Column(name = "updateTime", nullable = false, length = 0)
    private Date updateTime=new Date();//更新时间

    @OneToOne(targetEntity = Classes.class)
    @JoinColumn(name = "classId")
    private Classes classes;//班级外键


	public User() {
	}



    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPazzword() {
        return pazzword;
    }

    public void setPazzword(String pazzword) {
        this.pazzword = pazzword;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
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

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}