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
   
    .content {
        font-size: 1.3em;
    }
    .options>.input-append-wrapper {
        margin-bottom: 10px;
    }
    
    a.btn {
        padding-right: 10px;
    }
    
    .content-item {
        background-color: #fff;
        padding: 10px;
    }
    
    .content-item i {
        width: 15px;
        text-align: center;
    }
    
    .avatar {
        width: 80px;
        height: 100px;
        margin-right: 10px;
    }
    
    .avatar-span>.info {
        vertical-align: top;
        margin-top: 15px;
    }  
</style>
</head>
<body>
<div class="main">
    <div class="header">
        <p>个人中心</p>
    </div>
    
    <div class="content">
        <div class="avatar-span content-item mrg20B">
            <i class="glyph-icon icon-angle-right float-right" style="margin-top: 40px;"></i>
            <img class="avatar" src="<%=request.getContextPath() %>/public/img/attend-test-0031.jpg">
            <div class="info display-inline">
                <div><span class="font-gray">姓名：</span> 刘铎</div>
                <div><span class="font-gray">职称：</span> 副教授</div>
                <div><span class="font-gray">研究方向：</span> 信息安全、密码学</div>
            </div>
        </div>
        
        <div class="content-item mrg10B">
            <i class="glyph-icon icon-bell-alt float-left font-orange mrg10R"></i>
            <i class="glyph-icon icon-angle-right float-right"></i>
            <p>我的消息</p>
        </div>
        
        <div class="content-item mrg10B" style="margin-bottom: 40px;">
            <i class="glyph-icon icon-info float-left font-blue mrg10R"></i>
            <i class="glyph-icon icon-angle-right float-right"></i>
            <p>基本信息</p>
        </div>
        <div class="content-item" style="margin-bottom: 40px; display: none;">
            <i class="glyph-icon icon-lock float-left font-gray mrg10R"></i>
            <i class="glyph-icon icon-angle-right float-right"></i>
            <p>修改密码</p>
        </div>
        
        <div class="content-item mrg10B">
            <i class="glyph-icon icon-gear float-left font-purple mrg10R"></i>
            <i class="glyph-icon icon-angle-right float-right"></i>
            <p>提醒设置</p>
        </div>
    </div>
    
    <div class="nav-footer footer">
        <div class="row">
            <div class="col-xs-4 nav-item" onclick="location.href='school-notify.html'">
                <div class="icon"><i class="glyph-icon fa-bell"></i></div>
                <div class="text">通知</div>
            </div>
            <div class="col-xs-4 nav-item" onclick="location.href='index.html'">
                <div class="icon"><i class="glyph-icon fa-book"></i></div>
                <div class="text">课程</div>
            </div>
            <div class="col-xs-4 nav-item selected" onclick="location.href='teacher-user.html'">
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