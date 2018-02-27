package com.cn.action;

import com.cn.model.User;
import com.cn.service.UserServiceI;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//用户方法
@Results({@Result(name = "input", location = "add"),
        @Result(name = "list", type = "redirect", location = ""),
        @Result(name = "success", type = "redirect", location = "view/${id}"),
        @Result(name = "redirect", type = "redirect", location = "${redirect}")})
public class UserAction extends BaseAction {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(UserAction.class);

    private User user=new User();
    private List<User> users=new ArrayList<>();

    @Resource
    private UserServiceI userServiceI;

    public void save() {
        try {
            userServiceI.save(user);
            super.success(null);
        } catch (Exception e) {
            super.fail();
            logger.error(e);
        }
    }

    public void delete() {
        try {
            userServiceI.delete(id);
            super.success(null);
        } catch (Exception e) {
            super.fail();
            logger.error(e);
        }
    }

    public void update() {
        try {
            userServiceI.update(user);
            super.success(user);
        } catch (Exception e) {
            super.fail();
            logger.error(e);
        }
    }

    public String list() {
        users = userServiceI.list();
        return "list";
    }

    public String students(){
        users = userServiceI.students();
        return "list";
    }

    public String general(){
        users = userServiceI.general();
        return "list";
    }


    public void login(){
        Map<String, Object> params = new HashMap<>();
        params.put("account", user.getAccount());
        params.put("pazzword", user.getPazzword());
        params.put("type", user.getType());
        User u=userServiceI.login(params);
        if (u == null) {
                super.fail();
        } else {
            super.success(u);
        }

    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
