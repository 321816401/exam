package com.cn.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 班级表
 */
@Entity
@Table(name = "classes", catalog = "exam")
public class Classes implements java.io.Serializable {

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



	public Classes() {
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


}