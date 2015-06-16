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
   
    .list-content {
        width: auto !important;
        max-width: 75%;
    }
</style>
</head>
<body>
<div class="content-box bg-white">
    <ul class="notifications-box">
        <li>
            <span class="float-left font-gray">课程名称</span>
            <span class="notification-text float-right list-content">软件系统分析与设计技术</span>
        </li>
        <li>
            <span class="float-left font-gray">开课学院</span>
            <span class="notification-text float-right list-content">软件学院</span>
        </li>
        <li>
            <span class="float-left font-gray">任课老师</span>
            <span class="notification-text float-right list-content">张红延</span>
        </li>
        <li>
            <span class="float-left font-gray">上课时间</span>
            <span class="notification-text float-right list-content">1-16周 周三第1节 周五第2节</span>
        </li>
        <li>
            <span class="float-left font-gray">上课地点</span>
            <span class="notification-text float-right list-content">逸夫楼 YF106</span>
        </li>
        <li>
            <span class="float-left font-gray">课容量</span>
            <span class="notification-text float-right list-content">80</span>
        </li>
        <li style="height: auto;">
            <span class="float-left font-gray">课程简介</span>
            <span class="notification-text float-right list-content">
                <p style="white-space: normal;">CSS 选择器参考手册我们会定期对 W3School 的 CSS 参考手册进行浏览器测试。CSS3 选择器在CSS 中,选择器是一种模式,用于选择需要添加样式的元素。"CSS" 列指示该属性是在哪个 CSS</p>
            </span>
        </li>
    </ul>
</div>
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/home/footer.jsp" %>
</body>
</html>