﻿<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
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
    <title>题目管理</title>
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
                <div class="tree-leaf "><a href="curriculum.jsp">课程管理</a></div>
                <div class="tree-leaf"><a href="questions.jsp">题库管理</a></div>
                <div class="tree-leaf active"><a href="subject.jsp">题目管理</a></div>
                <div class="tree-leaf "><a href="testPaper.jsp">试卷管理</a></div>
                <div class="tree-leaf "><a href="student.jsp">学生管理</a></div>
            </div>
        </div>
    </div>
    <div class="form">
        <a href="addSubject.jsp" class="btn btn-success">添加</a>
        <table>
            <thead>
            <tr><th>名称</th><th>题型</th><th>选项</th><th>答案</th><th>分值</th><th>创建时间</th> <th>更新时间</th></tr>
            </thead>
            <tbody>
            <s:action name="Subject.list" id="subjectList" executeResult="false"></s:action>
            <s:iterator value="%{#subjectList.subjects}" status="rowStatus" var="c">
                <tr  id="${c.id}">
                    <td>${c.title}</td>
                    <td>${c.questions.name}</td>
                    <td>${c.optionA},${c.optionB},${c.optionC}</td>
                    <td>${c.answer}</td>
                    <td>${c.score}</td>
                    <td><fmt:formatDate value="${c.addTime }" pattern="yyyy-MM-dd HH:ss"/></td>
                    <td><fmt:formatDate value="${c.updateTime }" pattern="yyyy-MM-dd HH:ss"/></td>
                    <td>
                        <a href="editSubject.jsp?id=${c.id}" class="btn btn-success">修改</a>
                        <a href="javaScript:;" onclick="del(${c.id})" class="btn btn-danger">删除</a>
                    </td>
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
            url:'/ssh/Subject.delete.action?id='+id,
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