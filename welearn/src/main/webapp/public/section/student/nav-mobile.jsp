<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="nav-footer footer">
	<div class="row">
	    <c:if test="${type ==  1}">
            <div class="col-xs-4 nav-item selected" onclick="location.href='query-public.html'">
        </c:if> 	
        <c:if test="${type !=  1}">
            <div class="col-xs-4 nav-item" onclick="location.href='query-public.html'">
        </c:if> 		
			<div class="icon">
				<i class="glyph-icon fa-paw"></i>
			</div>
			<div class="text">公共查询</div>
		</div>
	    <c:if test="${type ==  2}">
            <div class="col-xs-4 nav-item selected" onclick="location.href='course-list-alt.html'">
        </c:if> 	
        <c:if test="${type !=  2}">
            <div class="col-xs-4 nav-item" onclick="location.href='course-list-alt.html'">
        </c:if> 		
			<div class="icon">
				<i class="glyph-icon fa-book"></i>
			</div>
			<div class="text">我的课程</div>
		</div>
	    <c:if test="${type ==  3}">
            <div class="col-xs-4 nav-item selected" onclick="location.href='student-user.html'">
        </c:if> 	
        <c:if test="${type !=  3}">
            <div class="col-xs-4 nav-item" onclick="location.href='student-user.html'">
        </c:if> 		
			<div class="icon">
				<i class="glyph-icon fa-user"></i>
			</div>
			<div class="text">个人中心</div>
		</div>
	</div>
</div>