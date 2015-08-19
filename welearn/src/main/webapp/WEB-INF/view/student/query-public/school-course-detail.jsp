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
    
    ul.notifications-box {
    	margin-top: 55px!important;
    }
</style>
</head>
<body>
<div class="main bg-white">
	<div class="header">
		<i class="glyph-icon icon-chevron-left float-left btn-back"></i>
        <p>${course.getName() }</p>
    </div>
    <ul class="notifications-box">
        <li>
            <span class="float-left font-gray">课程名称</span>
            <span class="notification-text float-right list-content">${course.getName() }</span>
        </li>
        <li>
            <span class="float-left font-gray">开课学院</span>
            <span class="notification-text float-right list-content">${course.getSchool() }</span>
        </li>
        <li>
            <span class="float-left font-gray">任课老师</span>
            <span class="notification-text float-right list-content">${course.getTeacher() }</span>
        </li>
        <li>
            <span class="float-left font-gray">上课时间</span>
            <span class="notification-text float-right list-content">${course.getTime() }</span>
        </li>
        <li>
            <span class="float-left font-gray">上课地点</span>
            <span class="notification-text float-right list-content">${course.getPlace() }</span>
        </li>
        <li>
            <span class="float-left font-gray">课容量</span>
            <span class="notification-text float-right list-content">${course.getCapacity() }</span>
        </li>
        <li style="height: auto;">
            <span class="float-left font-gray">课程简介</span>
            <span class="notification-text float-right list-content">
                <p style="white-space: normal">${course.getDescription() }</p>
            </span>
        </li>
    </ul>
</div>
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/home/footer.jsp" %>
</body>
</html>