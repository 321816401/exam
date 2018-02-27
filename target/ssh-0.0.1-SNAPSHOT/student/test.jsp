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
    <title>试卷管理</title>
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
                <div class="tree-leaf"><a href="index.jsp?id=${param.id}">个人信息</a></div>
                <div class="tree-leaf"><a href="score.jsp?id=${param.id}">考试成绩</a></div>
                <div class="tree-leaf active"><a href="test.jsp?id=${param.id}">参加考试</a></div>
            </div>
        </div>
    </div>
    <div class="form">
        <table>
            <thead>
            <tr> <th>名称</th> <th>课程</th><th>出卷人</th><th>创建时间</th> <th>更新时间</th></tr>
            </thead>
            <tbody>
            <s:action name="TestPaper.list" id="testPaperList" executeResult="false"></s:action>
            <s:iterator value="%{#testPaperList.testPapers}" status="rowStatus" var="c">
                <tr id="${c.id}">
                    <td>${c.name}</td>
                    <td>${c.curriculum.name}</td>
                    <td>${c.user.name}</td>
                    <td>${c.score}</td>
                    <td>${c.subjectNum}</td>
                    <td><fmt:formatDate value="${c.addTime }" pattern="yyyy-MM-dd HH:ss"/></td>
                    <td><fmt:formatDate value="${c.updateTime }" pattern="yyyy-MM-dd HH:ss"/></td>
                    <td>
                        <a href="exam.jsp?id=${param.id}&testPaperId=${c.id}" class="btn btn-success">参加考试</a>
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

</script>
</body>
</html>