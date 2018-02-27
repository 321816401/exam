package com.cn.action;

import com.cn.model.Classes;
import com.cn.service.ClassesServiceI;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import javax.annotation.Resource;
import java.util.List;

@Results({@Result(name = "input", location = "add"),
        @Result(name = "list", type = "redirect", location = ""),
        @Result(name = "success", type = "redirect", location = "view/${id}"),
        @Result(name = "redirect", type = "redirect", location = "${redirect}")})
public class ClassesAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ClassesAction.class);

    private List<Classes> classesList;
    private Classes classes=new Classes();
    @Resource
	private ClassesServiceI classesServiceI;



    public void save() {
        try {
            classesServiceI.save(classes);
            super.success(null);
        } catch (Exception e) {
            super.fail();
            logger.error(e);
        }
    }

    public void delete() {
        try {
            classesServiceI.delete(id);
            super.success(null);
        } catch (Exception e) {
            super.fail();
            logger.error(e);
        }
    }

    public void update() {
        try {
            classesServiceI.update(classes);
            super.success(classes);
        } catch (Exception e) {
            super.fail();
            logger.error(e);
        }
    }

    public String list() {
        classesList = classesServiceI.list();
        return "list";
    }

    public String view() {
        classes=classesServiceI.view(classes.getId());
        return "list";
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public List<Classes> getClassesList() {
        return classesList;
    }

    public void setClassesList(List<Classes> classesList) {
        this.classesList = classesList;
    }
}
