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
				<i class="glyph-icon fa-bell"></i>
			</div>			
			<div class="text">通知</div>
		</div>
        <c:if test="${type ==  2}">
            <div class="col-xs-4 nav-item selected" onclick="location.href='query-public.html'">
        </c:if> 	
        <c:if test="${type != 2}">
            <div class="col-xs-4 nav-item" onclick="location.href='query-public.html'">
        </c:if> 
			<div class="icon">
				<i class="glyph-icon fa-book"></i>
			</div>
			<div class="text">课程</div>
		</div>
        <c:if test="${type ==  3}">
            <div class="col-xs-4 nav-item selected" onclick="location.href='query-public.html'">
        </c:if> 	
        <c:if test="${type != 3}">
            <div class="col-xs-4 nav-item" onclick="location.href='query-public.html'">
        </c:if> 
			<div class="icon">
				<i class="glyph-icon fa-user"></i>
			</div>
			<div class="text">个人</div>
		</div>
	</div>
</div>
