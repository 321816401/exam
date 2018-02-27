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
    <title>成绩</title>
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
                <div class="tree-leaf"><a href="subject.jsp">题目管理</a></div>
                <div class="tree-leaf "><a href="testPaper.jsp">试卷管理</a></div>
                <div class="tree-leaf active"><a href="student.jsp">学生管理</a></div>
            </div>
        </div>
    </div>
    <div class="form">
        <table>
            <thead>
            <tr>
                <th>试卷</th>
                <th>分数</th>
                <th>开始考试时间</th>
                <th>结束考试时间</th>
            </tr>
            </thead>
            <tbody>
            <s:action name="Score.list" id="ScoreList" executeResult="false">
                <s:param name="score.user.id">${param.id}</s:param>
            </s:action>
            <s:iterator value="%{#ScoreList.scores}" status="rowStatus" var="c">
                <tr id="${c.id}">
                    <td>${c.testPaper.name}</td>
                    <td>${c.number }</td>
                    <td><fmt:formatDate value="${c.addTime }" pattern="yyyy-MM-dd HH:ss"/></td>
                    <td><fmt:formatDate value="${c.updateTime }" pattern="yyyy-MM-dd HH:ss"/></td>
                </tr>
            </s:iterator>
            </tbody>
        </table>

    </div>
</div>
<script type="text/javascript" src="../script/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../script/js/base.js"></script>
</body>
</html>