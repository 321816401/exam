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
    <title>添加课程</title>
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
    <form class="form">
        <div><span>名称</span><input type="text" name="subject.title"></div>
        <div><span>题型</span>
            <s:action name="Questions.list" id="questionsList" executeResult="false"></s:action>
            <select name="subject.questions.id">
                <s:iterator value="%{#questionsList.questionses}" status="rowStatus" var="c">
                    <option value="${c.id}">${c.name}</option>
                </s:iterator>
            </select>
        </div>
        <div><span>选项a</span><input type="text"  name="subject.optionA"></div>
        <div><span>选项b</span><input type="text" name="subject.optionB"></div>
        <div><span>选项c</span><input type="text"  name="subject.optionC"></div>
        <div><span>分值</span><input type="text"  name="subject.score"></div>
        <div><span>答案</span><input type="text" name="subject.answer"></div>
        <a class="btn btn-success" onclick="save()">确认</a>
        <a class="btn btn-info" onclick="history.go(-1)">取消</a>
    </form>
</div>
<script type="text/javascript" src="../script/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../script/js/base.js"></script>
<script>
    function save(){
        $.ajax({
            url:'/ssh/Subject.save.action?'+$("form").serialize(),
            type:'POST',
            dataType:'json',
            success:function(data){
                if(data.status==1){
                    window.location.href="subject.jsp"
                }else{
                    alert("添加失败");
                }
            }
        })
    }
</script>
</body>
</html>