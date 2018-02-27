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
    <title>修改课程</title>
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
                <div class="tree-leaf"><a href="index.jsp">个人信息</a></div>
                <div class="tree-leaf active"><a href="curriculum.jsp">课程管理</a></div>
                <div class="tree-leaf"><a href="questions.jsp">题库管理</a></div>
                <div class="tree-leaf"><a href="subject.jsp">题目管理</a></div>
                <div class="tree-leaf "><a href="testPaper.jsp">试卷管理</a></div>
                <div class="tree-leaf "><a href="student.jsp">学生管理</a></div>
            </div>
        </div>
    </div>
    <s:action name="Curriculum.view" id="view" executeResult="false">
        <s:param name="curriculum.id">${param.id}</s:param>
    </s:action>
    <form class="form">
        <input type="hidden" name="curriculum.id" value="${param.id}">
        <input type="hidden" name="curriculum.user.id" value="${view.curriculum.user.id}">
        <input type="hidden" name="curriculum.addTime" value="${view.curriculum.addTime}">
        <div><span>名称</span><input type="text" name="curriculum.name" value="${view.curriculum.name}"></div>
        <div><span>介绍</span><input type="text"  name="curriculum.content" value="${view.curriculum.content}"></div>
        <a class="btn btn-success" onclick="update()">确认</a>
        <a class="btn btn-info" onclick="history.go(-1)">取消</a>
    </form>
</div>
<script type="text/javascript" src="../script/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../script/js/base.js"></script>
<script>
    function update(){
        $.ajax({
            url:'/ssh/Curriculum.update.action?'+$("form").serialize(),
            type:'POST',
            dataType:'json',
            success:function(data){
                if(data.status==1){
                    window.location.href="curriculum.jsp"
                }else{
                    alert("添加失败");
                }
            }
        })
    }
</script>
</body>
</html>