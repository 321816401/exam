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
    <title>个人信息</title>
</head>
<body>
<div class="top"> <%@include file="../include/top.jsp"%></div>
<div class="main">
    <div class="left-menu">
        <div class="tree-menu">
            <div class="tree-trunk"></div>
            <div class="tree-body">
                <div class="tree-leaf active"><a href="index.jsp">个人信息</a></div>
                <div class="tree-leaf "><a href="curriculum.jsp">课程管理</a></div>
                <div class="tree-leaf"><a href="questions.jsp">题库管理</a></div>
                <div class="tree-leaf"><a href="subject.jsp">题目管理</a></div>
                <div class="tree-leaf "><a href="testPaper.jsp">试卷管理</a></div>
                <div class="tree-leaf"><a href="student.jsp">学生管理</a></div>
            </div>
        </div>
    </div>
    <form class="form">
        <input type="hidden" name="user.id" id="id">
        <input type="hidden" name="user.addTime" id="addTime">
        <div><span>编号</span><input type="text" name="user.code" id="code"></div>
        <div><span>姓名</span><input type="text" name="user.name" id="name"></div>
        <div><span>性别</span><select name="user.sex" id="sex"><option value="男">男</option><option value="女">女</option> </select></div>
        <div><span>班级</span>
            <s:action name="Classes.list" id="classesList" executeResult="false"></s:action>
            <select name="user.classes.id" id="classesId">
                <s:iterator value="%{#classesList.classesList}" status="rowStatus" var="c">
                    <option value="${c.id}">${c.name}</option>
                </s:iterator>
            </select>
        </div>
        <div><span>账号</span><input type="text" name="user.account" id="account"></div>
        <div><span>密码</span><input type="password" name="user.pazzword" id="pazzword"></div>
        <a class="btn btn-success" onclick="update()">确认</a>
    </form>
</div>
<script type="text/javascript" src="../script/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../script/js/base.js"></script>
<script>
    $(function(){
        var user=JSON.parse(sessionStorage.getItem("user"));
        $("#id").val(user.id);
        $("#addTime").val(user.addTime);
        $("#code").val(user.code);
        $("#name").val(user.name);
        $("#sex").val(user.sex);
        $("#account").val(user.account);
        $("#pazzword").val(user.pazzword);
        $("#classesId").val(user.classes.id);
    })
    function update(){
        $.ajax({
            url:'/ssh/User.update.action?'+$("form").serialize(),
            type:'POST',
            dataType:'json',
            success:function(data){
                if(data.status==1){
                    sessionStorage.setItem("user", JSON.stringify(data.data));
                    alert("修改成功");
                }else{
                    alert("修改失败");
                }
            }
        })
    }

</script>
</body>
</html>