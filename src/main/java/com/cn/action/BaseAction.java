package com.cn.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/")
@ParentPackage("basePackage")
public class BaseAction extends ActionSupport implements RequestAware, SessionAware, ApplicationAware {

	private static final long serialVersionUID = 1L;
    public Integer id;
	private Map<String, Object> request;
	private Map<String, Object> session;
	private Map<String, Object> application;

	public void success(Object o) {
        Map<String, Object> params=new HashMap<>();
        params.put("status",1);
        params.put("data",o);
		try {
			String json = JSON.toJSONStringWithDateFormat(params, "yyyy-MM-dd HH:mm:ss");
			ServletActionContext.getResponse().setContentType("json/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(json);
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    public void fail() {
        Map<String, Object> params=new HashMap<>();
        params.put("status",-1);
        try {
            String json = JSON.toJSONStringWithDateFormat(params, "yyyy-MM-dd HH:mm:ss");
            ServletActionContext.getResponse().setContentType("json/html;charset=utf-8");
            ServletActionContext.getResponse().getWriter().write(json);
            ServletActionContext.getResponse().getWriter().flush();
            ServletActionContext.getResponse().getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Map<String, Object> getRequest() {
		return request;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getApplication() {
		return application;
	}

	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

}
