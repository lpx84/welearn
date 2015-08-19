<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/public/section/teacher/header-mobile.jsp"%>
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
                <div><span class="font-gray">学号：</span> ${student.getStudentNo() }</div>
                <div><span class="font-gray">姓名：</span> ${student.getTrueName() }</div>
                <div><span class="font-gray">级别：</span> 普通用户</div>
            </div>
        </div>
        
        
        <div class="content-item border-bottom">
            <i class="glyph-icon icon-lock float-left font-blue mrg10R"></i>
            <i class="glyph-icon icon-angle-right float-right"></i>
            <p>安全中心</p>
        </div>
        <div class="content-item mrg10B">
            <i class="glyph-icon icon-gear float-left font-blue mrg10R"></i>
            <i class="glyph-icon icon-angle-right float-right"></i>
            <p>提醒设置</p>
        </div>
        
        <div class="content-item border-bottom" onclick="location.href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx80c237b3b2300b0a&redirect_uri=http%3A%2F%2Fbdxst.bjtu.edu.cn%2Fwelearn%2Fstudent%2Fquery%2Fpersonal%2course-schedule&response_type=code&scope=snsapi_base&state=123#wechat_redirect'">
            <i class="glyph-icon fa fa-calendar float-left font-blue mrg10R"></i>
            <i class="glyph-icon icon-angle-right float-right"></i>
            <p>我的课表</p>
        </div>
        <div class="content-item border-bottom" onclick="location.href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx80c237b3b2300b0a&redirect_uri=http%3A%2F%2Fbdxst.bjtu.edu.cn%2Fwelearn%2Fstudent%2Fquery%2Fpersonal%2Fcourse-grade&response_type=code&scope=snsapi_base&state=123#wechat_redirect'">
            <i class="glyph-icon fa fa-area-chart float-left font-blue mrg10R"></i>
            <i class="glyph-icon icon-angle-right float-right"></i>
            <p>我的成绩</p>
        </div>
        <div class="content-item border-bottom" onclick="location.href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx80c237b3b2300b0a&redirect_uri=http%3A%2F%2Fbdxst.bjtu.edu.cn%2Fwelearn%2Fstudent%2Fquery%2Fpersonal%2Fexam-plan&response_type=code&scope=snsapi_base&state=123#wechat_redirect'">
            <i class="glyph-icon fa fa-list-alt float-left font-blue mrg10R"></i>
            <i class="glyph-icon icon-angle-right float-right"></i>
            <p>我的考试安排</p>
        </div>
        <div class="content-item border-bottom" onclick="location.href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx80c237b3b2300b0a&redirect_uri=http%3A%2F%2Fbdxst.bjtu.edu.cn%2Fwelearn%2Fstudent%2Fquery%2Fpersonal%2Fecard&response_type=code&scope=snsapi_base&state=123#wechat_redirect'">
            <i class="glyph-icon fa fa-credit-card float-left font-blue mrg10R"></i>
            <i class="glyph-icon icon-angle-right float-right"></i>
            <p>我的一卡通</p>
        </div>
        <div class="content-item mrg10B" onclick="location.href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx80c237b3b2300b0a&redirect_uri=http%3A%2F%2Fbdxst.bjtu.edu.cn%2Fwelearn%2Fstudent%2Fquery%2Fpersonal%2Fnet-flow&response_type=code&scope=snsapi_base&state=123#wechat_redirect'">
            <i class="glyph-icon fa fa-globe float-left font-blue mrg10R"></i>
            <i class="glyph-icon icon-angle-right float-right"></i>
            <p>上网流量</p>
        </div>
    </div>
    
    <div class="nav-footer footer">
        <div class="row">
            <div class="col-xs-4 nav-item" onclick="location.href='query-public.html'">
                <div class="icon"><i class="glyph-icon fa-paw"></i></div>
                <div class="text">公共查询</div>
            </div>
            <div class="col-xs-4 nav-item" onclick="location.href='course-list-alt.html'">
                <div class="icon"><i class="glyph-icon fa-book"></i></div>
                <div class="text">我的课程</div>
            </div>
            <div class="col-xs-4 nav-item selected" onclick="location.href='student-user.html'">
                <div class="icon"><i class="glyph-icon fa-user"></i></div>
                <div class="text">个人中心</div>
            </div>
        </div>
    </div>
</div>
<%@ include file="/public/section/public.jsp"%>
<%@ include file="/public/section/student/nav-mobile.jsp"%>
<script type="text/javascript">

</script>
</body>
</html>