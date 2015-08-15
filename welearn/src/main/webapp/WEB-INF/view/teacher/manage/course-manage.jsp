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
    
    .header {
        font-size: 1.2em;
        line-height: 2.5em;
        background-color: #A7DEFF;
    }
    
    .img img {
        width: 100%;
    }
    
    .menu-item .item-inner {
        margin: 5px;
        padding: 10px;
        background: #A7DEFF;
        border-radius: 4px;
    }
    .menu-item .fa {
        font-size: 3em;
    }
    
    .menu-item p {
        font-size: 0.8em;
        margin-top: 5px;
    }   
   
</style>
</head>
<body>
<div class="main">
    <div class="header">
        <p>这里是课程名称</p>
    </div>
    <div class="img">
        <img src="../img/teacher-index.jpg">
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
            <div class="item-inner">
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
    
</div>
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/teacher/nav-mobile.jsp" %>
<script type="text/javascript">

</script>
</body>
</html>