<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/public/section/teacher/header-mobile.jsp" %>
<title>${title }</title>
<style type="text/css">
    .main {
        text-align: center;
    }
    
    .img img {
        width: 100%;
    }
   
</style>
</head>
<body>
<div class="main">
    <div class="header">
        <p>${courseName }</p>
    </div>
    <div class="img">
        <img src="<%=request.getContextPath() %>/public/img/teacher-index.jpg">
    </div>
    <div class="search"></div>
    <div class="menu row">
        <div class="menu-item col-xs-4 col-sm-3 col-md-3 col-lg-3">
            <div class="item-inner">
                <i class="fa fa-bullhorn" style="color: #33AB90;"></i>
                <p>公告管理</p>
            </div>
        </div>
        <div class="menu-item col-xs-4 col-sm-3 col-md-3 col-lg-3">
            <div class="item-inner">
                <i class="fa fa-list-alt font-blue"></i>
                <p>作业管理</p>
            </div>
        </div>
        <div class="menu-item col-xs-4 col-sm-3 col-md-3 col-lg-3">
            <div class="item-inner">
                <i class="fa fa-comments font-green"></i>
                <p>课程讨论</p>
            </div>
        </div>
        <div class="menu-item col-xs-4 col-sm-3 col-md-3 col-lg-3">
            <div class="item-inner" onclick="javascript: location.href='attend-list'">
                <i class="fa fa-camera" style="color:#EFA0A0;"></i>
                <p>签到管理</p>
            </div>
        </div>
        <div class="menu-item col-xs-4 col-sm-3 col-md-3 col-lg-3">
            <div class="item-inner">
                <i class="fa fa-lightbulb-o font-purple"></i>
                <p>测评管理</p>
            </div>
        </div>
        <div class="menu-item col-xs-4 col-sm-3 col-md-3 col-lg-3">
            <div class="item-inner">
                <i class="fa fa-star-half-o font-orange"></i>
                <p>课程反馈</p>
            </div>
        </div>
    </div>
    <div class="nav-footer footer">
        <div class="row">
            <div class="col-xs-4 nav-item">
                <div class="icon"><i class="glyph-icon fa-bell"></i></div>
                <div class="text">通知</div>
            </div>
            <div class="col-xs-4 nav-item selected">
                <div class="icon"><i class="glyph-icon fa-book"></i></div>
                <div class="text">课程</div>
            </div>
            <div class="col-xs-4 nav-item">
                <div class="icon"><i class="glyph-icon fa-user"></i></div>
                <div class="text">个人</div>
            </div>
        </div>
    </div>
</div>
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/teacher/nav-mobile.jsp" %>
<script type="text/javascript">

</script>
</body>
</html>