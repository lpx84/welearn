<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 	<div class="nav-footer footer">
        <div class="row">
            <c:when test="${type == NavTypeEnum.NOTIFY }">
                <div class="col-xs-4 nav-item selected">
            </c:when>
            <c:otherwise>
                <div class="col-xs-4 nav-item">
            </c:otherwise>
                <div class="icon"><i class="glyph-icon fa-bell"></i></div>
                <div class="text">通知</div>
            </div>
            <c:when test="${type == NavTypeEnum.COURSE }">
                <div class="col-xs-4 nav-item selected">
            </c:when>
            <c:otherwise>
                <div class="col-xs-4 nav-item">
            </c:otherwise>
                <div class="icon"><i class="glyph-icon fa-book"></i></div>
                <div class="text">课程</div>
            </div>
            <c:when test="${type == NavTypeEnum.PERSONAL }">
                <div class="col-xs-4 nav-item selected">
            </c:when>
            <c:otherwise>
                <div class="col-xs-4 nav-item">
            </c:otherwise>
                <div class="icon"><i class="glyph-icon fa-user"></i></div>
                <div class="text">个人</div>
            </div>
        </div>
  </div>
  