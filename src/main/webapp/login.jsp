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
    <link rel="stylesheet" href="script/css/base.css" type="text/css"/>
    <title>登陆</title>
</head>
<body class="login">
<div class="login-content">
    <div class="box">
        <div class="title">考试系统</div>
        <form class="input">
            <div><input type="text" id="username" name="user.account" placeholder="请输入用户名"></div>
            <div><input type="password" id="password" name="user.pazzword" placeholder="请输入密码"></div>
            <div>
                <select id="select"  name="user.type">
                    <option value="1">老师</option>
                    <option value="2">学生</option>
                    <option value="3">管理员</option>
                </select>
            </div>
            <div><a href="javascript:;" class="btn" onclick="login()">登陆</a></div>
        </form>
    </div>
</div>
<script type="text/javascript" src="script/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="script/js/base.js"></script>
<script>
    function login(){
        var _username=$("#username");
        var _password=$("#password");
        if(_username.val()==""){
            validate(_username,7);
            return;
        }
        if(_password.val()==""){
            validate(_password,7);
            return;
        }
        $.ajax({
            url:'/ssh/User.login.action?'+$("form").serialize(),
            type:'POST',
            dataType:'json',
            success:function(data){
                if(data.status==1){
                    sessionStorage.setItem("user", JSON.stringify(data.data));
                    if($("#select").val()=="1"){
                        window.location.href="teacher/index.jsp"
                    }else if($("#select").val()=="2"){
                        window.location.href="student/index.jsp?id="+data.data.id
                    }else if($("#select").val()=="3"){
                        window.location.href="manager/user.jsp"
                    }
                }else{
                   alert("密码错误");
                }
            }
        })
    }

</script>
</body>
</html>