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
    <title>学生管理管理</title>
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
            <tr> <th>姓名</th><th>学号</th><th>班级</th></tr>
            </thead>
            <tbody>
            <s:action name="User.students" id="userList" executeResult="false"></s:action>
            <s:iterator value="%{#userList.users}" status="rowStatus" var="c">
            <tr>
                <td>${c.name}</td>
                <td>${c.code}</td>
                <td>${c.classes.name}</td>
                <td><a href="score.jsp?id=${c.id}" class="btn btn-success">查看考试成绩</a></td>
            </tr>
            </s:iterator>
            </tbody>
        </table>

    </div>
</div>
<script type="text/javascript" src="../script/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../script/js/base.js"></script>
<script>

</script>
</body>
</html>