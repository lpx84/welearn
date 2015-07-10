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
   
   
</style>
</head>
<body>
<div class="content-box bg-white">
    <div class="button-pane button-pane-top pad10A">
        <div class="form-row pad0B">
            <div class="form-input col-md-12">
                <div class="form-input-icon">
                    <i class="glyph-icon icon-search transparent"></i>
                    <input type="text" placeholder="输入查询课程" class="radius-all-100" name="" id="" />
                </div>
            </div>
        </div>
    </div>
    <div class="">
        <div class="scrollable-content">

            <ul class="notifications-box">
                <li onclick="javascript:location.href='school-course-detail.html';">
                    <span class="btn bg-green icon-notification glyph-icon icon-list"></span>
                    <span class="notification-text">软件系统分析与设计</span>
                    <div class="notification-time">软件学院</div>
                </li>
                <li onclick="javascript:location.href='school-course-detail.html';">
                    <span class="btn bg-green icon-notification glyph-icon icon-list"></span>
                    <span class="notification-text">软件系统分析与设计</span>
                    <div class="notification-time">软件学院</div>
                </li>
                <li onclick="javascript:location.href='school-course-detail.html';">
                    <span class="btn bg-green icon-notification glyph-icon icon-list"></span>
                    <span class="notification-text">软件系统分析与设计</span>
                    <div class="notification-time">软件学院</div>
                </li>
                <li onclick="javascript:location.href='school-course-detail.html';">
                    <span class="btn bg-green icon-notification glyph-icon icon-list"></span>
                    <span class="notification-text">软件系统分析与设计</span>
                    <div class="notification-time">电子信息工程学院</div>
                </li>
                <li onclick="javascript:location.href='school-course-detail.html';">
                    <span class="btn bg-green icon-notification glyph-icon icon-list"></span>
                    <span class="notification-text">软件系统分析与设计</span>
                    <div class="notification-time">软件学院</div>
                </li>
                
            </ul>

        </div>
    </div>
</div>
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/home/footer.jsp" %>
<script type="text/javascript">

</script>
</body>
</html>