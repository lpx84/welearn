<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/public/section/home/header.jsp" %>
<title>${title }</title>
<style type="text/css">
   .title {
        display: inline-block;
        text-align: center;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
    }
    .content-head {
        line-height: 2em;
        border-bottom: 1px solid #f2f2f2;
        margin-top: 10px;
        margin-bottom: 20px;
    }
    
    span.lab {
        color: #d3d3d3;
        display: inline-block;
        width: 70px;
        margin-right: 10px;
        text-align: right;
        vertical-align: top;
    }
    
    .large-text {
        display: inline-block;
        width: 70%;
    }
    
    .limit-text {
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
    }
    
    .row {
        width: 100%;
    }
    
    .toggle {
        text-align: right;
        padding-right: 15px;
        font-size: 2em;
        color: #C3C3C3;
        margin-top: -15px;
    }
    
    .nav-list ul li {
        font-size: 1.2em;
        padding: 5px 10px;
    }   
</style>
</head>
<body>
<div class="content-box">
    <h3 class="content-box-header bg-gray text-center">
    	<div class="glyph-icon icon-separator transparent" onclick="javascript: location.href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx80c237b3b2300b0a&redirect_uri=http%3A%2F%2Fbdxst.bjtu.edu.cn%2Fwelearn%2Fstudent%2Fmanage%2Fcourse%2Fcourse-list&response_type=code&scope=snsapi_base&state=123#wechat_redirect';">
            <i class="glyph-icon fa-chevron-left"></i>
        </div>
        <label class="title">${course.getName() }</label>
        <div class="glyph-icon icon-separator transparent float-right">
            <i class="glyph-icon"></i>
        </div>
    </h3>
    <div class="content">
        <div class="content-head">
            <div class="row">
                <div class="col-xs-6 col-sm-6">
                    <span class="lab">课程号：</span>
                    <span>${course.getCourseNo() }</span>
                </div>
                <div class="col-xs-5 col-sm-5">
                    <span class="lab">学分：</span>
                    <span>${course.getCredit() }</span>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 col-sm-12">
                    <span class="lab">开课学院：</span>
                    <span>${course.getSchool() }</span>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 col-sm-12">
                    <span class="lab">任课教师：</span>
                    <span>${course.getTeacher() }</span>
                </div>
                
            </div>
            <div class="row">
                <div class="col-xs-12 col-sm-12">
                    <span class="lab">联系方式：</span>
                    <span>${course.getTeacherTel() }</span>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 col-sm-12">
                    <span class="lab">课程简介：</span>
                    <span class="large-text limit-text">${course.getDescription() }</span>
                </div>
            </div>
            <div class="toggle"><i class="fa fa-angle-double-down text-toggle"></i></div>
        </div>

        <div class="nav-list">
            <ul>
                <li>
                    <a href="course-homework?courseid=${course.getId() }">
                        <i class="glyph-icon font-blue-alt fa-archive"></i>
                        课程作业
                        <i class="glyph-icon icon-chevron-right float-right"></i>
                    </a>
                </li>
                <li>
                    <a href="course-notify?courseid=${course.getId() }">
                        <i class="glyph-icon font-orange fa-bell"></i>
                        课程公告
                        <i class="glyph-icon icon-chevron-right float-right"></i>
                    </a>
                </li>
                <li>
                    <a href="course-discuss?courseid=${course.getId() }">
                        <i class="glyph-icon font-green fa-weixin"></i>
                        课程讨论
                        <i class="glyph-icon icon-chevron-right float-right"></i>
                    </a>
                </li>
                <li>
                    <a href="course-test?courseid=${course.getId() }">
                        <i class="glyph-icon font-azure fa-lightbulb-o"></i>
                        在线测评
                        <i class="glyph-icon icon-chevron-right float-right"></i>
                    </a>
                </li>
                <li>
                    <a href="attend-list?courseid=${course.getId() }">
                        <i class="glyph-icon font-purple fa-list-ol"></i>
                        考勤记录
                        <i class="glyph-icon icon-chevron-right float-right"></i>
                    </a>
                </li>
                <li>
                    <a href="course-feedback?courseid=${course.getId() }">
                        <i class="glyph-icon font-gray fa-star-half-o"></i>
                        课程反馈
                        <i class="glyph-icon icon-chevron-right float-right"></i>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/home/footer.jsp" %>
<script type="text/javascript">
$(".text-toggle").click(function(){
    if($(this).hasClass("fa-angle-double-down")) {
        $(".large-text").removeClass("limit-text");
        $(this).removeClass("fa-angle-double-down");            
        $(this).addClass("fa-angle-double-up");            
    } else {
        $(".large-text").addClass("limit-text");
        $(this).removeClass("fa-angle-double-up");            
        $(this).addClass("fa-angle-double-down");
    }
});
</script>
</body>
</html>