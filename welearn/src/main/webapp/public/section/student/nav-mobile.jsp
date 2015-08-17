<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% String path = request.getContextPath(); %>
<div class="nav-footer footer">
	<div class="row">
	    <c:if test="${type ==  1}">
            <div class="col-xs-4 nav-item selected" onclick="location.href='<%=path %>/student/query/public/public-index'">
        </c:if> 	
        <c:if test="${type !=  1}">
            <div class="col-xs-4 nav-item" onclick="location.href='<%=path %>/student/query/public/public-index'">
        </c:if> 		
			<div class="icon">
				<i class="glyph-icon fa-paw"></i>
			</div>
			<div class="text">公共查询</div>
		</div>
	    <c:if test="${type ==  2}">
            <div class="col-xs-4 nav-item selected" onclick="location.href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx80c237b3b2300b0a&redirect_uri=http%3A%2F%2Fbdxst.bjtu.edu.cn%2Fwelearn%2Fstudent%2Fmanage%2Fcourse%2Fcourse-list&response_type=code&scope=snsapi_base&state=123#wechat_redirect'">
        </c:if> 	
        <c:if test="${type !=  2}">
            <div class="col-xs-4 nav-item" onclick="location.href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx80c237b3b2300b0a&redirect_uri=http%3A%2F%2Fbdxst.bjtu.edu.cn%2Fwelearn%2Fstudent%2Fmanage%2Fcourse%2Fcourse-list&response_type=code&scope=snsapi_base&state=123#wechat_redirect'">
        </c:if> 		
			<div class="icon">
				<i class="glyph-icon fa-book"></i>
			</div>
			<div class="text">我的课程</div>
		</div>
	    <c:if test="${type ==  3}">
            <div class="col-xs-4 nav-item selected" onclick="location.href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx80c237b3b2300b0a&redirect_uri=http%3A%2F%2Fbdxst.bjtu.edu.cn%2Fwelearn%2Fstudent%2Fquery%2Fpersonal%2Fpersonal-index&response_type=code&scope=snsapi_base&state=123#wechat_redirect'">
        </c:if> 	
        <c:if test="${type !=  3}">
            <div class="col-xs-4 nav-item" onclick="location.href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx80c237b3b2300b0a&redirect_uri=http%3A%2F%2Fbdxst.bjtu.edu.cn%2Fwelearn%2Fstudent%2Fquery%2Fpersonal%2Fpersonal-index&response_type=code&scope=snsapi_base&state=123#wechat_redirect'">
        </c:if> 		
			<div class="icon">
				<i class="glyph-icon fa-user"></i>
			</div>
			<div class="text">个人中心</div>
		</div>
	</div>
</div>