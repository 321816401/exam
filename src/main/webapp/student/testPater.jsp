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
    <title>语文考试试卷</title>
</head>
<body>
<div class="top"><%@include file="../include/top.jsp"%></div>
<div class="main">
    <div class="left-menu">
        <div class="tree-menu">
            <div class="tree-trunk"></div>
            <div class="tree-body">
                <div class="tree-leaf"><a href="index.jsp?id=${param.id}">个人信息</a></div>
                <div class="tree-leaf active"><a href="score.jsp?id=${param.id}">考试成绩</a></div>
                <div class="tree-leaf"><a href="test.jsp?id=${param.id}">参加考试</a></div>
            </div>
        </div>
    </div>
    <div class="form">
        <div class="subject-type">
            <div class="subject-title">选择题</div>
            <div class="subject-content">
                <div class="subject-view">
                    <div class="subject-question">
                        <p>题目1</p>
                        <p><input value="b" readonly></p>
                        <p>正确答案<span>a</span></p>
                    </div>
                    <div class="subject-option"><p>a.选项</p><p>b.选项</p><p>c.选项c</p></div>
                </div>
                <div class="subject-view">
                    <div class="subject-question">
                        <p>题目1</p>
                        <p><input value="b" readonly></p>
                        <p>正确答案<span>a</span></p>
                    </div>
                    <div class="subject-option"><p>a.选项</p><p>b.选项</p><p>c.选项c</p></div>
                </div>
            </div>
        </div>
        <div class="subject-type">
            <div class="subject-title">填空题</div>
            <div class="subject-content">
                <div class="subject-view">
                    <div class="subject-question">
                        <p>题目1</p>
                        <p><input value="aaaaa" readonly></p>
                        <p>正确答案<span>aaaa</span></p>
                    </div>
                </div>
                <div class="subject-view">
                    <div class="subject-question">
                        <p>题目1</p>
                        <p><input value="aaaaa" readonly></p>
                        <p>正确答案<span>aaaa</span></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="../script/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../script/js/base.js"></script>
<script>


</script>
</body>
</html>