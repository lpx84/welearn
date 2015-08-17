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
   
    .img img {
        width: 100%;
    }   
</style>
</head>
<body>
<div class="main">
    <div class="header">
        <p>我的课程</p>
    </div>
    <div class="img">
        <img src="<%=request.getContextPath() %>/public/img/student-index.jpg">
    </div>
    <div class="search form-row pad0B mrg5A">
        <div class="form-input">
            <div class="form-input-icon">
            <form id="search-course" action="" method="POST">
                <input type="text" placeholder="输入关键字" class="radius-all-100" name="keyword" id="keyword" onkeydown="javascript:enterSearch();"/>
                <i class="glyph-icon fa-search"></i>
                <input type="submit" style="display:none;">
            </form>
            </div>
        </div>
    </div>
    
    <div class="span-head font-size-15">
        <i class="glyph-icon icon-double-angle-right"></i>&nbsp;我的课程
    </div>
    <div class="course-list">
     <c:forEach var="item" items="${list }">
        <div class="item pad5A" onclick="javascript: location.href='course-manage-alt.html';">
            <div class="display-inline">
                <div class="name">【4A210Q】操作系统</div>
                <div class="comment pad5L">
                    <span class="font-gray">
                        <i class="glyph-icon icon-time"></i>&nbsp;2014~2015第二学期
                    </span>
                    <span class="label bg-blue-alt">刘铎</span>
                    <span class="label bg-green">专业限选课</span>
                </div>
            </div>
            <div class="display-inline float-right">
                <i class="glyph-icon icon-chevron-right"></i>
            </div>
        </div>
    </c:forEach>

    <div class="span-more">
        <a href="javascript:void(0);" class="btn btn-more medium ui-state-default">
            <span class="button-content">已显示全部</span>
        </a>
    </div>
</div>
<%@ include file="/public/section/public.jsp" %>
<%@ include file="/public/section/home/footer.jsp" %>
<%@ include file="/public/section/student/nav-mobile.jsp" %>
<script type="text/javascript">

</script>
</body>
</html>