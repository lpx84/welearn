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
        width: 72%;
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
    <h3 class="content-box-header bg-gray">
        <div class="glyph-icon icon-separator transparent back-btn">
            <i class="glyph-icon fa-chevron-left"></i>
        </div>
        <span class="title">${course.getName() }</span>
        <div class="glyph-icon icon-separator transparent float-right">
            <i class="glyph-icon"></i>
        </div>
    </h3>
    <div class="content">
        <div class="content-head">
            <div class="row">
                <div class="col-xs-6 col-sm-6">
                    <span class="lab">课程号：</span>
                    <span>${course.getName() }</span>
                </div>
                <div class="col-xs-5 col-sm-5">
                    <span class="lab">学分：</span>
                    <span>2</span>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 col-sm-12">
                    <span class="lab">开课学院：</span>
                    <span>计算机信息技术学院</span>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 col-sm-12">
                    <span class="lab">任课教师：</span>
                    <span>张红延</span>
                </div>
                
            </div>
            <div class="row">
                <div class="col-xs-12 col-sm-12">
                    <span class="lab">联系方式：</span>
                    <span>010-23424254</span>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 col-sm-12">
                    <span class="lab">课程简介：</span>
                    <span class="large-text limit-text">软件工程专业研究方法论与创新教育着重培养同学的创新能力，让同学做到敢想、善做、懂表达。</span>
                </div>
            </div>
            <div class="toggle"><i class="fa fa-angle-double-down text-toggle"></i></div>
        </div>
<!--
        <div class="content-oper">
            <ul>
                <li><i class="fa fa-weixin"></i>&nbsp;&nbsp;课程讨论</li>
                <li><i class="fa fa-weixin"></i>&nbsp;&nbsp;课程讨论</li>
                <li><i class="fa fa-weixin"></i>&nbsp;&nbsp;课程讨论</li>
                
            </ul>
        </div>
-->
        <div class="nav-list">
            <ul>
                <li>
                    <a href="course-homework.html">
                        <i class="glyph-icon font-blue-alt fa-archive"></i>
                        课程作业
                        <i class="glyph-icon icon-chevron-right float-right"></i>
                    </a>
                </li>
                <li>
                    <a href="course-notify.html">
                        <i class="glyph-icon font-orange fa-bell"></i>
                        课程公告
                        <i class="glyph-icon icon-chevron-right float-right"></i>
                    </a>
                </li>
                <li>
                    <a href="course-discuss.html">
                        <i class="glyph-icon font-green fa-weixin"></i>
                        课程讨论
                        <i class="glyph-icon icon-chevron-right float-right"></i>
                    </a>
                </li>
                <li>
                    <a href="">
                        <i class="glyph-icon font-azure fa-lightbulb-o"></i>
                        在线测评
                        <i class="glyph-icon icon-chevron-right float-right"></i>
                    </a>
                </li>
                <li>
                    <a href="attend-list.html">
                        <i class="glyph-icon font-purple fa-list-ol"></i>
                        考勤记录
                        <i class="glyph-icon icon-chevron-right float-right"></i>
                    </a>
                </li>
                <li>
                    <a href="course-feedback.html">
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
});s
</script>
</body>
</html>