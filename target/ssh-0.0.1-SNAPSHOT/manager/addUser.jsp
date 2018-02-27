<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=3, minimum-scale=1, user-scalable=no">
    <link rel="stylesheet" href="../script/css/base.css" type="text/css"/>
    <link rel="stylesheet" href="../script/css/sytle.css" type="text/css"/>
    <title>添加用户</title>
</head>
<body>
<div class="top">
    <%@include file="../include/top.jsp"%>
</div>
<div class="main">
    <div class="left-menu">
        <div class="tree-menu">
            <div class="tree-trunk"></div>
            <div class="tree-body">
                <div class="tree-leaf active"><a href="user.jsp">用户管理</a></div>
            </div>
        </div>
    </div>
    <form class="form">
        <div><span>类型</span><select name="user.sex"><option value="1">老师</option><option value="2">学生</option> </select></div>
        <div><span>账号</span><input type="text" name="user.account"></div>
        <div><span>密码</span><input type="text"  name="user.pazzword"></div>
        <div><span>号码</span><input type="text" name="user.code"></div>
        <div><span>姓名</span><input type="text" name="user.name"></div>
        <div><span>性别</span><select name="user.sex"><option value="男">男</option><option value="女">女</option> </select></div>
        <div><span>班级</span>
            <s:action name="Classes.list" id="classesList" executeResult="false"></s:action>
            <select name="user.classes.id">
                <s:iterator value="%{#classesList.classesList}" status="rowStatus" var="c">
                    <option value="${c.id}">${c.name}</option>
                </s:iterator>
            </select>
        </div>
        <a class="btn btn-success" onclick="save()">确认</a>
        <a class="btn btn-info" onclick="history.go(-1)">取消</a>
    </form>
</div>
<script type="text/javascript" src="../script/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../script/js/base.js"></script>
<script>
    function save(){
        $.ajax({
            url:'/ssh/User.save.action?'+$("form").serialize(),
            type:'POST',
            dataType:'json',
            success:function(data){
                if(data.status==1){
                    window.location.href="user.jsp"
                }else{
                    alert("添加失败");
                }
            }
        })
    }
</script>
</body>
</html>