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
        <p>公共查询</p>
    </div>
    
    <div class="content">
        <div class="content-item mrg10B mrg10T" onclick="location.href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx80c237b3b2300b0a&redirect_uri=http%3A%2F%2Fbdxst.bjtu.edu.cn%2Fwelearn%2Fstudent%2Fquery%2Fpublic%2Fempty-room&response_type=code&scope=snsapi_base&state=123#wechat_redirect'">
            <i class="glyph-icon fa fa-building-o float-left font-blue mrg10R"></i>
            <i class="glyph-icon icon-angle-right float-right"></i>
            <p>自习教室</p>
        </div>
        
        <div class="content-item mrg10B" onclick="location.href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx80c237b3b2300b0a&redirect_uri=http%3A%2F%2Fbdxst.bjtu.edu.cn%2Fwelearn%2Fstudent%2Fquery%2Fpublic%2Fschool-course&response_type=code&scope=snsapi_base&state=123#wechat_redirect'">
            <i class="glyph-icon fa fa-search float-left font-blue mrg10R"></i>
            <i class="glyph-icon icon-angle-right float-right"></i>
            <p>全校课程查询</p>
        </div>
        <div class="content-item mrg10B" onclick="location.href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx80c237b3b2300b0a&redirect_uri=http%3A%2F%2Fbdxst.bjtu.edu.cn%2Fwelearn%2Fstudent%2Fquery%2Fpublic%2Fschool-schedule&response_type=code&scope=snsapi_base&state=123#wechat_redirect'">
            <i class="glyph-icon fa fa-calendar float-left font-blue mrg10R"></i>
            <i class="glyph-icon icon-angle-right float-right"></i>
            <p>交大校历</p>
        </div>
        <div class="content-item" style="margin-bottom: 40px;" onclick="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx80c237b3b2300b0a&redirect_uri=http%3A%2F%2Fbdxst.bjtu.edu.cn%2Fwelearn%2Fstudent%2Fquery%2Fpublic%2Fschool-notify&response_type=code&scope=snsapi_base&state=123#wechat_redirect'">
            <i class="glyph-icon fa fa-bell float-left font-blue mrg10R"></i>
            <i class="glyph-icon icon-angle-right float-right"></i>
            <p>教务通知</p>
        </div>
        
        <div class="content-item mrg10B" onclick="location.href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx80c237b3b2300b0a&redirect_uri=http%3A%2F%2Fbdxst.bjtu.edu.cn%2Fwelearn%2Fstudent%2Fquery%2Fpublic%2Flost-thing&response_type=code&scope=snsapi_base&state=123#wechat_redirect'">
            <i class="glyph-icon fa fa-globe float-left font-blue mrg10R"></i>
            <i class="glyph-icon icon-angle-right float-right"></i>
            <p>失物招领</p>
        </div>
    </div>
    
</div>
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/student/nav-mobile.jsp" %>
<script type="text/javascript">

</script>
</body>
</html>