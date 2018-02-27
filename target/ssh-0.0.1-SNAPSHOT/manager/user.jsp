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
    <title>用户管理</title>
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
                <div class="tree-leaf "><a href="classes.jsp">班级管理</a></div>
            </div>
        </div>
    </div>
    <div class="form">
        <a href="addUser.jsp" class="btn btn-success">添加用户</a>
        <table>
            <thead>
            <tr><th>职位</th><th>姓名</th><th>账号</th><th>编号/学号</th><th>班级</th><th>性别</th></tr>
            </thead>
            <tbody>
            <s:action name="User.general" id="userList" executeResult="false"></s:action>
            <s:iterator value="%{#userList.users}" status="rowStatus" var="user">
            <tr id="${user.id}">
                <td>
                    <c:if test="${user.type==1}">老师</c:if>
                    <c:if test="${user.type==2}">学生</c:if>
                </td>
                <td>${user.name}</td>
                <td>${user.account}</td>
                <td>${user.code}</td>
                <td>${user.classes.name}</td>
                <td>${user.sex}</td>
                <td><a href="javaScript:;" onclick="del(${user.id})" class="btn btn-danger" >删除</a></td>
            </tr>
            </s:iterator>
            </tbody>
        </table>

    </div>
</div>
<script type="text/javascript" src="../script/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../script/js/base.js"></script>
<script>
    function del(id){
        $.ajax({
            url:'/ssh/User.delete.action?id='+id,
            type:'POST',
            dataType:'json',
            success:function(data){
                if(data.status==1){
                   $("#"+id).remove();
                    alert("删除成功");
                }else{
                    alert("删除失败");
                }
            }
        })
    }
</script>
</body>
</html>