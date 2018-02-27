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
                <div class="tree-leaf "><a href="curriculum.jsp">课程管理</a></div>
                <div class="tree-leaf"><a href="questions.jsp">题库管理</a></div>
                <div class="tree-leaf active"><a href="subject.jsp">题目管理</a></div>
                <div class="tree-leaf "><a href="testPaper.jsp">试卷管理</a></div>
                <div class="tree-leaf "><a href="student.jsp">学生管理</a></div>
            </div>
        </div>
    </div>
    <s:action name="Subject.view" id="view" executeResult="false">
        <s:param name="subject.id">${param.id}</s:param>
    </s:action>
    <form class="form">
        <input type="hidden" name="subject.id" value="${param.id}">
        <input type="hidden" name="subject.addTime" value="${view.subject.addTime}">
        <div><span>名称</span><input type="text" name="subject.title" value="${view.subject.title}"></div>
        <div><span>题型${view.subject.questions.id}</span>
            <s:action name="Questions.list" id="questionsList" executeResult="false"></s:action>
            <select name="subject.questions.id">
                <s:iterator value="%{#questionsList.questionses}" status="rowStatus" var="c">
                    <option value="${c.id}" <c:if test="${view.subject.questions.id==c.id}">selected="selected" </c:if>>${c.name}</option>
                </s:iterator>
            </select>
        </div>
        <div><span>选项a</span><input type="text" name="subject.optionA" value="${view.subject.optionA}"></div>
        <div><span>选项b</span><input type="text"  name="subject.optionB" value="${view.subject.optionB}"></div>
        <div><span>选项c</span><input type="text" name="subject.optionC" value="${view.subject.optionC}"></div>
        <div><span>分值</span><input type="text"  name="subject.score" value="${view.subject.score}"></div>
        <div><span>答案</span><input type="text" name="subject.answer" value="${view.subject.answer}"></div>
        <a class="btn btn-success" onclick="update()">确认</a>
        <a class="btn btn-info" onclick="history.go(-1)">取消</a>
    </form>
</div>
<script type="text/javascript" src="../script/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../script/js/base.js"></script>
<script>
    function update(){
        $.ajax({
            url:'/ssh/Subject.update.action?'+$("form").serialize(),
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