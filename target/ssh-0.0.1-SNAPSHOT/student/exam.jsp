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
    <s:action name="TestPaper.view" id="view" executeResult="false">
        <s:param name="testPaper.id">${param.id}</s:param>
    </s:action>
    <title>${view.testPaper.name}</title>
</head>
<body ng-app="myApp">
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
            <div class="subject-type">
                <div class="subject-content">
                    <s:action name="TestPaperSubject.testPaper" id="TestPaperSubjectList" executeResult="false">
                        <s:param name="testPaperSubject.testPaper.id">${param.testPaperId}</s:param>
                    </s:action>
                    <s:iterator value="%{#TestPaperSubjectList.testPaperSubjects}" status="rowStatus" var="tps">
                        <div class="subject-view">
                            <div class="subject-question">
                                <p subject="${tps.subject.id}">${tps.subject.title}</p>
                                <c:if test="${tps.subject.questions.name=='选择题'}">
                                    <p>
                                        <select class="vue">
                                            <option value="a">a</option>
                                            <option value="b">b</option>
                                            <option value="c">c</option>
                                        </select>
                                    </p>
                                </c:if>
                            </div>
                            <div class="subject-option">
                                <c:if test="${tps.subject.questions.name=='选择题'}">
                                    <p>a：${tps.subject.optionA}</p><p>b：${tps.subject.optionB}</p><p>c：${tps.subject.optionC}</p>
                                </c:if>
                                <c:if test="${tps.subject.questions.name=='填空题'}">
                                    <input type="text" class="vue">
                                </c:if>
                            </div>
                        </div>
                    </s:iterator>
                </div>
            </div>
        <a class="btn btn-success" onclick="sub()">交卷</a>
    </div>
</div>
<script type="text/javascript" src="../script/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../script/js/base.js"></script>
<script>
    function sub(){
        var subjects=[];
        $(".subject-view").each(function(){
            subjects.push($(this).find("p[subject]").attr("subject")+","+$(this).find(".vue").val())
        });
        $.ajax({
            url:'/ssh/Score.save.action',
            type:'POST',
            traditional: true,
            data:{
                "subjects": subjects,
                "score.testPaper.id":${param.id},
                "score.user.id": JSON.parse(sessionStorage.getItem("user")).id
            },
            dataType:'json',
            success:function(data){
                if(data.status==1){
                    window.location.href="score.jsp?id=${param.id}"
                }else{
                    alert("交卷失败");
                }
            }
        })
    }
</script>
</body>
</html>